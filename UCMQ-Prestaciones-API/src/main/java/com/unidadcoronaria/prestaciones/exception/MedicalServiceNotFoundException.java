package com.unidadcoronaria.prestaciones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Medical Service not found")  
public class MedicalServiceNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;

	public MedicalServiceNotFoundException(String aMessage) {
		super(aMessage);
	}

}
