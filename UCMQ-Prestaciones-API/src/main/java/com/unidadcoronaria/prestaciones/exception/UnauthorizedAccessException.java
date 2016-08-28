package com.unidadcoronaria.prestaciones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Authorization Required")  
public class UnauthorizedAccessException extends  BaseException {
	
	private static final long serialVersionUID = 1L;

	public UnauthorizedAccessException(String aMessage) {
		super(aMessage);
	}

}
