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
import com.unidadcoronaria.prestaciones.domain.MedicalService;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.MedicalServiceService;


@Controller
@EnableAutoConfiguration
public class MedicalServiceController {

	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private MedicalServiceService medicalService;
	
	@RequestMapping(value = "/medicalService",  method = RequestMethod.GET)
	@ResponseBody
	List<MedicalService> listMedicalService(@RequestHeader(value = Constants.AUTHORIZATION_HEADER, required = false) final String token) {
		this.authorizationService.validateToken(token);
		return this.medicalService.getMedicalServiceList();
	}
	
}
