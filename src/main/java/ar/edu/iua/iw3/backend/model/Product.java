package ar.edu.iua.iw3.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100, unique = true, nullable = false)
	private String product;
	
	@Column(columnDefinition = "tinyint default 1")
	private boolean stock=true;
	
	private double price;
	
	@Override
	public String toString() {
		return String.format("Id=%s, product=%s, stock=%s, price=%s", getId(), getProduct(), isStock(), getPrice());
	}
	
}
