package com.unidadcoronaria.prestaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.constant.Constants;
import com.unidadcoronaria.prestaciones.domain.TypeMobileObservation;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.TypeMobileObservationService;

@Controller
@EnableAutoConfiguration
public class TypeMobileObservationController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private TypeMobileObservationService typeMobileObservationService;
	
	@RequestMapping(value = "/typeMobileObservation",  method = RequestMethod.GET)
	@ResponseBody
	List<TypeMobileObservation> listTypeMobileObservation(@RequestHeader(value = Constants.AUTHORIZATION_HEADER, required = false) final String token) {
		this.authorizationService.validateToken("451236200698230");
		
		return typeMobileObservationService.getTypeMobileObservationList();
	}

}
