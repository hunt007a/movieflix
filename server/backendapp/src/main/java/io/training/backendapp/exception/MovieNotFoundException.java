package io.training.backendapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -8583507350723957385L;
	
	public MovieNotFoundException(String message){
		super(message);
	}
}
