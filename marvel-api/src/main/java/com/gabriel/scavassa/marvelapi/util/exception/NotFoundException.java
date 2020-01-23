package com.gabriel.scavassa.marvelapi.util.exception;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String obj) {
		super(obj + " not found");
	}

}
