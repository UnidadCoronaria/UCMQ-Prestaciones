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
import com.unidadcoronaria.prestaciones.domain.Diagnostic;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.DiagnosticService;

@Controller
@EnableAutoConfiguration
public class DiagnosticController {

	@Autowired
	private AuthorizationService authorizationService;

	@Autowired
	private DiagnosticService diagnosticService;

	@RequestMapping(value = "/diagnostic", method = RequestMethod.GET)
	@ResponseBody
	List<Diagnostic> listMedicament(@RequestHeader(value = Constants.AUTHORIZATION_HEADER) final String token) {
		this.authorizationService.validateToken(token);
		return diagnosticService.getDiagnosticList();
	}

}
