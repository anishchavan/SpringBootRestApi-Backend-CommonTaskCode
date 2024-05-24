package edu.cjc.springbootrestapicrudapp.app.servicei;

import java.util.List;

import edu.cjc.springbootrestapicrudapp.app.model.Customer;
import edu.cjc.springbootrestapicrudapp.app.model.Product;

public interface ServiceI {

	Product saveProduct(Product p);
	
	List<Product> getProduct();

	Product updateProduct(int id);

	List<Product> deleteProduct(int id);

	Product getProductByName(String productName);

	Customer saveCustomer(Customer c);

	List<Customer> getCustomers();

	List<Customer> deleteCustomer(int customerId);



}
