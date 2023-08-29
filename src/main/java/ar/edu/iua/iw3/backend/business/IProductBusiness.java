package ar.edu.iua.iw3.backend.business;

import java.util.List;

import ar.edu.iua.iw3.backend.model.Product;

public interface IProductBusiness {
	public Product load(long id) throws NotFoundException, BusinessException;

	public Product load(String product) throws NotFoundException, BusinessException;

	public List<Product> list() throws BusinessException;

	public Product add(Product product) throws FoundException, BusinessException;

	public Product update(Product product) throws NotFoundException, BusinessException;

	public void delete(long id) throws NotFoundException, BusinessException;
}
