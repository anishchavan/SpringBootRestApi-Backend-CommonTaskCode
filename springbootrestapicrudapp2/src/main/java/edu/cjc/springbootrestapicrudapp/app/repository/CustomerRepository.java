package edu.cjc.springbootrestapicrudapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cjc.springbootrestapicrudapp.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
