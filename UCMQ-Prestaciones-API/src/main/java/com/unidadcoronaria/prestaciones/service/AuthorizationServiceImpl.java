package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.exception.UnauthorizedAccessException;
import com.unidadcoronaria.prestaciones.repository.ResourceRepository;

/**
 * @author AGUSTIN.BALA
 *
 */

@Component("authorizationService")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

	final static Logger logger = Logger.getLogger(AuthorizationServiceImpl.class);	
	
	/*@Value("${prestaciones.bearer}")
	private String bearer;*/
	
	@Autowired
    private ResourceRepository resourceRepository;
	
	@Override
	public void validateToken(String token) {
		/* Commented for testing purposes
		String splittedToken = token.split(bearer + " ")[1];*/
		if (!validateTokenOnServer(token)) {
			throw new UnauthorizedAccessException("Authorization Required - Token sent by client is incorrect");
		}
	}
	
	private Boolean validateTokenOnServer(String token){
		// TODO: Validate against DB
		Boolean isValid = false;

		if(resourceRepository.findResourceByImei(token) != null){
			isValid = true;
		} 
			
		return isValid;
	}

}
