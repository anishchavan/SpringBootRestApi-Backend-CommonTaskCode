package edu.cjc.springbootrestapicrudapp.app.exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
