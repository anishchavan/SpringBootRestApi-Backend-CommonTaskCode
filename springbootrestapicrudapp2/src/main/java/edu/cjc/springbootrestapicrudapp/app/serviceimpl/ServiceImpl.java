package edu.cjc.springbootrestapicrudapp.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import edu.cjc.springbootrestapicrudapp.app.model.Product;
import edu.cjc.springbootrestapicrudapp.app.repository.ProductRepository;
import edu.cjc.springbootrestapicrudapp.app.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {
	@Autowired
	ProductRepository pr;
	
	
	
	@Override
	public Product saveProduct(Product p) {
			return pr.save(p);
		
	}
	@Override
	public List<Product> getProduct() {
		return pr.findAll();
	}
	@Override
	public Product updateProduct(int id) {
		return pr.findById(id).get();
	}
	@Override
	public List<Product> deleteProduct(int id) {
		pr.deleteById(id);
		return pr.findAll();
	}
	@Override
	public Product getProductByName(String productName) {
		Product p = pr.findByProductName(productName);
		if(p!=null) {
			return p;
		}else {
			throw new ProductNotFoundException("We regret to inform you that we did not found appropriate product");
		}
	}
	
	


	
}
