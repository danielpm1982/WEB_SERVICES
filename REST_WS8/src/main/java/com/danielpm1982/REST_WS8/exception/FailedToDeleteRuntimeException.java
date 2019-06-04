package com.danielpm1982.REST_WS8.exception;

public class FailedToDeleteRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public FailedToDeleteRuntimeException() {
		super();
	}
	public FailedToDeleteRuntimeException(String message) {
		super(message);
	}
}
