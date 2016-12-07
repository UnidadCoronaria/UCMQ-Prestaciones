package com.unidadcoronaria.prestaciones.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.domain.Guard;
import com.unidadcoronaria.prestaciones.domain.MobileObservation;
import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.domain.TypeMobileObservation;
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
	
	@RequestMapping(value = "/saveMobileObservation/{resourceId}/{typeMobileObservationId}/{guardId}/{observation}",  method = RequestMethod.GET)
	@ResponseBody
	void listMedicament(@PathVariable("resourceId") Integer resourceId, 
			            @PathVariable("typeMobileObservationId") Integer typeMobileObservationId,
			            @PathVariable("guardId") Integer guardId,
			            @PathVariable("observation") String observation) throws SQLException {
		this.authorizationService.validateToken("451236200698230");
		
		MobileObservation mobileObservation = new MobileObservation();
		Resource resource;
		resource = this.resourceService.getResourceByImei("451236200698230");
		TypeMobileObservation typeMobileObservation = new TypeMobileObservation(); 
		typeMobileObservation.setTypeMobileObservationId(typeMobileObservationId);
		Guard guard = new Guard();
		guard.setGuardId(guardId);
		
		mobileObservation.setMobile(resource.getMobile());
		mobileObservation.setTypeMobileObservation(typeMobileObservation);
		mobileObservation.setGuard(guard);
		mobileObservation.setObservation(observation);
		
		
	}	

}
