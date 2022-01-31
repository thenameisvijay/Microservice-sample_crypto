package com.github.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public CustomException() {
		this.message = "";
	}
	
	public CustomException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomException [message=" + message + "]";
	}
	
}
