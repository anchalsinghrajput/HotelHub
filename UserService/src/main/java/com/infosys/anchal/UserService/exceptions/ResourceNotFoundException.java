package com.infosys.anchal.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resouce not found on server !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
