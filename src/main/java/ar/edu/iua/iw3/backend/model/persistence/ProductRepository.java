package ar.edu.iua.iw3.backend.model.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.iua.iw3.backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findByProduct(String product);
	
	Optional<Product> findByProductAndIdNot(String product, long id);
	
}

