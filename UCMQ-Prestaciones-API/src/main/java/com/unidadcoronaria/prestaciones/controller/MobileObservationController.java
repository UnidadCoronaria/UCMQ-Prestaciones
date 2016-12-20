package com.unidadcoronaria.prestaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.constant.Constants;
import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.domain.dto.MobileObservationDTO;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.MobileObservationService;
import com.unidadcoronaria.prestaciones.service.ResourceProviderService;
import com.unidadcoronaria.prestaciones.service.ResourceService;

@Controller
@EnableAutoConfiguration
public class MobileObservationController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private MobileObservationService mobileObservationService;
	
	@Autowired
	private ResourceProviderService resourceProviderService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value = "/mobileObservation",  method = RequestMethod.POST)
	@ResponseBody
	void saveMobileObservation(@RequestBody MobileObservationDTO dto, @RequestHeader(value = Constants.AUTHORIZATION_HEADER ) final String token) {
		this.authorizationService.validateToken(token);
		Resource resource = resourceService.getResourceByImei("451236200698230");
		mobileObservationService.save(resource, dto);
	}	

}
