package com.unidadcoronaria.prestaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.constant.Constants;
import com.unidadcoronaria.prestaciones.domain.MedicalService;
import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.domain.Medicament;
import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.MedicalServiceResourceService;
import com.unidadcoronaria.prestaciones.service.MedicalServiceService;
import com.unidadcoronaria.prestaciones.service.MedicamentService;
import com.unidadcoronaria.prestaciones.service.ResourceService;


@Controller
@EnableAutoConfiguration
public class MedicalServiceController {

	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private MedicalServiceService medicalService;
	
	@Autowired
	private MedicalServiceResourceService medicalServiceResourceService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private MedicamentService medicamentService;
	
	@RequestMapping(value = "/medicalService",  method = RequestMethod.GET)
	@ResponseBody
	List<MedicalService> listMedicalService(@RequestHeader(value = Constants.AUTHORIZATION_HEADER, required = false) final String token) {
		this.authorizationService.validateToken("451236200698230");
		Resource resource;
		resource = this.medicalService.getResourceIdByImei("451236200698230");
		List<MedicalService> ms;
		ms = this.medicalService.getMedicalServiceList(resource.getResourceId());
		//return this.medicalService.getMedicalServiceList(resource.getResourceId());
		return ms;
	}
		
	@RequestMapping(value = "/sptest",  method = RequestMethod.GET)
	@ResponseBody
	List<MedicalService> listspTest(@RequestHeader(value = Constants.AUTHORIZATION_HEADER, required = false) final String token) {
		this.authorizationService.validateToken(token);
		return this.medicalService.getPrestacionesList() ;
	}
	
	@RequestMapping(value = "/medicalServiceResource",  method = RequestMethod.GET)
	@ResponseBody
	List<MedicalServiceResource> listMedicalServiceResource(@RequestHeader(value = Constants.AUTHORIZATION_HEADER, required = false) final String token) {
		this.authorizationService.validateToken("451236200698230");
		Resource resource;
		resource = this.resourceService.getResourceByImei("451236200698230");

		return this.medicalServiceResourceService.getMedicalServiceResourceList(resource.getResourceId());
	}
	
	@RequestMapping(value = "/currentState/{medicalServiceResourceId}",  method = RequestMethod.GET)
	@ResponseBody
	Integer getCurrentState(@PathVariable("medicalServiceResourceId") Integer medicalServiceResourceId) {
		this.authorizationService.validateToken("451236200698230");
		return medicalServiceResourceService.getMedicalServicesResourceCurrentState(medicalServiceResourceId);
	}
	
	@RequestMapping(value = "/authorizedStates/{medicalServiceResourceId}",  method = RequestMethod.GET)
	@ResponseBody
	List<Integer> getAuthorizedStates(@PathVariable("medicalServiceResourceId") Integer medicalServiceResourceId) {
		this.authorizationService.validateToken("451236200698230");
		return medicalServiceResourceService.getMedicalServicesResourceAuthorizedStates(medicalServiceResourceId);
	}
	
	@RequestMapping(value = "/setState/{medicalServiceResourceId}/{state}",  method = RequestMethod.GET)
	@ResponseBody
	void setState(@PathVariable("medicalServiceResourceId") Integer medicalServiceResourceId, @PathVariable("state") Integer state) {
		this.authorizationService.validateToken("451236200698230");
		medicalServiceResourceService.setMedicalServicesResourceState(medicalServiceResourceId, state);
	}
	
	@RequestMapping(value = "/medicaments",  method = RequestMethod.GET)
	@ResponseBody
	List<Medicament> listMedicament(@RequestHeader(value = Constants.AUTHORIZATION_HEADER, required = false) final String token) {
		this.authorizationService.validateToken("451236200698230");

		return medicamentService.getMedicamentList();
	}
	
}