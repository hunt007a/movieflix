package io.training.backendapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CommentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -8583507350723957385L;
	
	public CommentNotFoundException(String message){
		super(message);
	}
}
