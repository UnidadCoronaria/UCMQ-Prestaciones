package com.unidadcoronaria.prestaciones.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceMedicament;
import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.domain.Medicament;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.MedicalServiceMedicamentService;;


@Controller
@EnableAutoConfiguration
public class MedicalServiceMedicamentController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private MedicalServiceMedicamentService medicalServiceMedicamentService;
	
	@RequestMapping(value = "/saveMedicalServiceMedicament/{medicalServiceResourceId}/{medicamentId}/{amount}",  method = RequestMethod.GET)
	@ResponseBody
	void listMedicament(@PathVariable("medicalServiceResourceId") Integer medicalServiceResourceId, @PathVariable("medicamentId") Integer medicamentId, @PathVariable("amount") Double amount) throws SQLException {
		this.authorizationService.validateToken("451236200698230");
		
		MedicalServiceMedicament medicalServiceMedicament = new MedicalServiceMedicament();
		MedicalServiceResource medicalServiceResource = new MedicalServiceResource();
		Medicament medicament = new Medicament();
		
		medicalServiceResource.setMedicalServiceResourceId(medicalServiceResourceId);
		medicament.setMedicamentId(medicamentId);
		
		medicalServiceMedicament.setMedicalServiceResource(medicalServiceResource);
		medicalServiceMedicament.setMedicament(medicament);
		medicalServiceMedicament.setAmount(amount);
		
		medicalServiceMedicament = medicalServiceMedicamentService.save(medicalServiceMedicament);
		
		if(medicalServiceMedicament == null){
			throw new SQLException("Database exception!!!");
		}
		
	}
	
	@ExceptionHandler({java.sql.SQLException.class})
    public HttpStatus handleIOException(Exception ex) {
         
        return HttpStatus.BAD_REQUEST;
        
    }
	
	
	

}
