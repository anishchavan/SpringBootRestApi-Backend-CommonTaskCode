package edu.cjc.springbootrestapicrudapp.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cjc.springbootrestapicrudapp.app.model.Product;
import edu.cjc.springbootrestapicrudapp.app.servicei.ServiceI;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ServiceI si;
	
//	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p) {
		
//		try {
//			int a = 10/0;
//		}catch (Exception e) {
//			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
		Product product = si.saveProduct(p);
		
		log.info("info():- The product has been saved");
		log.warn("warn():- The product has been saved");
		log.debug("debug():- The product has been saved");
		log.trace("trace() :- The product has been saved");
		log.error("error():- The product has been saved");
		
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getProducts", produces = {"application/json", "application/xml"})
	public ResponseEntity<List<Product>> getProduct(){
		List<Product> productList = si.getProduct();
		log.info("{}",productList);
		log.info("Products has been retrieved successfully");
//		try {
//			int a = 10/0;
//		}catch (Exception e) {
//			log.error(e.getMessage());
//		}
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product p) {
		Product product = si.updateProduct(id);
		product.setProductId(p.getProductId());
		product.setProductName(p.getProductName());
		product.setProductType(p.getProductType());
		product.setProductPrice(p.getProductPrice());
		
		Product updatedProduct  = si.saveProduct(product);
		log.info("Product has been updated");
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<List<Product>> deleteProduct(@PathVariable int id) {
		List<Product> product = si.deleteProduct(id);
		log.info("Product of which id " + id + " has been deleted");
		return new ResponseEntity<List<Product>>(product,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/searchProduct/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName){
//		int a=10/0;
		Product product = si.getProductByName(productName);
		log.info("Product according to their name has been retrieved");
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	
}
