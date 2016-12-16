package com.unidadcoronaria.prestaciones.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.constant.Constants;
import com.unidadcoronaria.prestaciones.domain.dto.MedicalServiceMedicamentDTO;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.MedicalServiceMedicamentService;;


@Controller
@EnableAutoConfiguration
public class MedicalServiceMedicamentController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private MedicalServiceMedicamentService medicalServiceMedicamentService;
	
	@RequestMapping(value = "/medicalServiceMedicament",  method = RequestMethod.POST)
	@ResponseBody
	void saveMedicalServiceMedicament(@RequestBody MedicalServiceMedicamentDTO dto, @RequestHeader(value = Constants.AUTHORIZATION_HEADER ) final String token) throws SQLException {
		authorizationService.validateToken(token);
		medicalServiceMedicamentService.save(dto);
			
	}
	
	@ExceptionHandler({java.sql.SQLException.class})
    public HttpStatus handleIOException(Exception ex) {
         
        return HttpStatus.BAD_REQUEST;
        
    }
	
	
	

}
