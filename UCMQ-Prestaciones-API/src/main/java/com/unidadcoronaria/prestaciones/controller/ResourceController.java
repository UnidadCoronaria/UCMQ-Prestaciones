package com.unidadcoronaria.prestaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.constant.Constants;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.ResourceService;

@Controller
@EnableAutoConfiguration
public class ResourceController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value = "/resource/updateToken",  method = RequestMethod.PUT)
	@ResponseBody 
	public void updateToken(@RequestHeader(value = Constants.AUTHORIZATION_HEADER ) final String token, @RequestHeader(value = Constants.TOKENGCM_HEADER ) final String tokenGcm) {
		this.authorizationService.validateToken(token);
		resourceService.updateResource(token, tokenGcm);
	}

}
