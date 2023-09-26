package ar.edu.iua.iw3.backend.model.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.iua.iw3.backend.model.Category;
import ar.edu.iua.iw3.backend.model.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	Optional<Category> findOneByCategory(String category);
	
	
	
}

