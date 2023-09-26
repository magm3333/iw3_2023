package ar.edu.iua.iw3.backend.integration.cli2.business;

import java.util.Date;
import java.util.List;

import ar.edu.iua.iw3.backend.business.BusinessException;
import ar.edu.iua.iw3.backend.integration.cli2.model.ProductCli2;

public interface IProductCli2Business {
	public List<ProductCli2> listExpired(Date date) throws BusinessException;
}

