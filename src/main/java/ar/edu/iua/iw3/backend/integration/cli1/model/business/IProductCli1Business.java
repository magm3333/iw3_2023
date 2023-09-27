package ar.edu.iua.iw3.backend.integration.cli1.model.business;

import java.util.List;

import ar.edu.iua.iw3.backend.business.BusinessException;
import ar.edu.iua.iw3.backend.business.FoundException;
import ar.edu.iua.iw3.backend.business.NotFoundException;
import ar.edu.iua.iw3.backend.integration.cli1.model.ProductCli1;

public interface IProductCli1Business {

	public ProductCli1 load(String codCli1) throws NotFoundException, BusinessException;
	public List<ProductCli1> list() throws BusinessException;
	public ProductCli1 add(ProductCli1 product) throws FoundException, BusinessException;
	public ProductCli1 addExternal(String json) throws FoundException, BusinessException;

}

