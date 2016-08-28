package com.unidadcoronaria.prestaciones.exception;

/**
 * @author agustin.bala
 *
 */
public class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = 844869885632588534L;
	
	public BaseException(final String aMessage){
		super(aMessage);
	}

	
}
