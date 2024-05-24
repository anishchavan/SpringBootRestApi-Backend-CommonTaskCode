package edu.cjc.springbootrestapicrudapp.app.exception;

public class CustomerListIsEmptyException extends RuntimeException {
	public CustomerListIsEmptyException(String msg) {
		super(msg);
	}
}
