package io.training.backendapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MovieAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = -759468624671133790L;
	public MovieAlreadyExistException(String message){
		super(message);
	}
}
