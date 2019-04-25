package com.danielpm1982.REST_WS2.exception;

public class FailedToDeleteRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public FailedToDeleteRuntimeException() {
		super();
	}
	public FailedToDeleteRuntimeException(String message) {
		super(message);
	}
}

/*
This is a simple custom runtime exception that inherits from RuntimeException class,
receives the error message and sends that message to the RuntimeException super constructor.
It can be handled by the ExceptionMapper class for returning a Response to the Consumer client, with
better semantics than java exceptions do, regarding REST APIs.
*/
