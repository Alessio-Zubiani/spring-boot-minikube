package com.example.minikube.exception;

public class BicompException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BicompException(String message) {
        super(message);
    }
	
	public BicompException(Throwable t) {
        super(t);
    }

}
