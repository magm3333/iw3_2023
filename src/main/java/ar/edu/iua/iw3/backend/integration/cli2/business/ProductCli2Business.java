package ar.edu.iua.iw3.backend.integration.cli2.business;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ar.edu.iua.iw3.backend.business.BusinessException;
import ar.edu.iua.iw3.backend.integration.cli2.model.ProductCli2;
import ar.edu.iua.iw3.backend.integration.cli2.model.ProductCli2SlimView;
import ar.edu.iua.iw3.backend.integration.cli2.model.persistence.ProductCli2Respository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Profile({ "cli2", "mysqlprod" })
public class ProductCli2Business implements IProductCli2Business {

	@Autowired(required = false)
	private ProductCli2Respository productDAO;

	@Override
	public List<ProductCli2> listExpired(Date date) throws BusinessException {
		try {
			return productDAO.findByExpirationDateBeforeOrderByExpirationDateDesc(date);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}
	
	@Override
	public List<ProductCli2SlimView> listSlim() throws BusinessException {
		try {
			return productDAO.findByOrderByPriceDesc();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}


}
