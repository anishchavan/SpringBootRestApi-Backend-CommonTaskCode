package edu.cjc.springbootrestapicrudapp.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.cjc.springbootrestapicrudapp.app.exception.CustomerListIsEmptyException;
import edu.cjc.springbootrestapicrudapp.app.model.Customer;
import edu.cjc.springbootrestapicrudapp.app.servicei.ServiceI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ServiceI si;
	
	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer c) {
		Customer customer = si.saveCustomer(c);
		log.info("Customer has been saved");
		return customer;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		List<Customer> cList = si.getCustomers();
		if(cList.isEmpty()){
			log.warn("WARNING!!! WARNING!!!");
			throw new CustomerListIsEmptyException("Customer list is empty");
		}else {
			return cList;
		}
		
		
	}
	
	@DeleteMapping("/customer/{customerId}")
	public List<Customer> deleteCustomer(@PathVariable int customerId) {
		List<Customer> cList = si.deleteCustomer(customerId);
		return cList;
	}
	
	
}
