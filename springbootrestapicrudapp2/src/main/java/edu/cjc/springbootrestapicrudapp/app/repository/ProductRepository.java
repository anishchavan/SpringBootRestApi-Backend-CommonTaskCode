package edu.cjc.springbootrestapicrudapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.cjc.springbootrestapicrudapp.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByProductName(String productName);

}
