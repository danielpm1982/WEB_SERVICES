package com.danielpm1982.SOAP_WS5.exceptions;

public class InvalidNameException extends Exception{
	private static final long serialVersionUID = 1L;
	private String name;
	public InvalidNameException(String name) {
		this.name=name;
	}
	@Override
	public String getMessage() {
		return ((name==null)||name.equals(""))?("Input name null or empty!"):("Input name is invalid (must be at least 5 chars): "+name+"!"); 
	}
}
