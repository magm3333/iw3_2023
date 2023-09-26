package ar.edu.iua.iw3.backend.integration.cli2.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.iw3.backend.business.BusinessException;
import ar.edu.iua.iw3.backend.integration.cli2.business.IProductCli2Business;
import ar.edu.iua.iw3.backend.util.IStandartResponseBusiness;
import ar.edu.iua.iw3.backend.util.controllers.BaseRestController;
import ar.edu.iua.iw3.backend.util.controllers.Constants;

@RestController
@RequestMapping(Constants.URL_INTEGRATION_CLI2 + "/products")
@Profile({ "cli2", "mysqlprod" })
public class ProductCli2RestController extends BaseRestController {

	@Autowired
	private IProductCli2Business productBusiness;
	
	//GET http://localhost:8080/api/{pathparam}/products?param=valor&param1=valor1&since=2023-09-26%2016:45:09 http1.1
	//http://localhost:8080/api/{pathparam}/products?param=valor&param1=valor1&since=2023-09-26 16:45:09
    // {bodyparam}
	
	@Autowired
	private IStandartResponseBusiness response;

	@GetMapping(value = "/list-expired", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listExpired(
			@RequestParam(name = "since", required = false, defaultValue = "1970-01-01 00:00:00") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date since) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(since);
			if (c.get(Calendar.YEAR) == 1970) {
				since = new Date();
			}
			return new ResponseEntity<>(productBusiness.listExpired(since), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(response.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

