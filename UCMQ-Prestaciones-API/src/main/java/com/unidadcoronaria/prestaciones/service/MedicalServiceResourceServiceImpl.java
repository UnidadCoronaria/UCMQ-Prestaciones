package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceResourceRepository;

@Component("medicalServiceResource")
@Transactional
public class MedicalServiceResourceServiceImpl implements MedicalServiceResourceService {
	
	final static Logger logger = Logger.getLogger(MedicalServiceResourceServiceImpl.class);
	
	@Autowired
    private MedicalServiceResourceRepository medicalServiceResourceRepository;

	public List<MedicalServiceResource> getMedicalServiceResourceList(Integer resourceId) {
		
		return medicalServiceResourceRepository.findByResourceId(resourceId);
	}
	
	public MedicalServiceResource getMedicalServiceResource(Integer medicalServiceResourceId) {
		
		return medicalServiceResourceRepository.findByMedicalServiceResourceId(medicalServiceResourceId);
	}
	
	public Integer getMedicalServicesResourceCurrentState(Integer medicalServiceResourceId) {
		
		return medicalServiceResourceRepository.getMedicalServicesResourceCurrentState(medicalServiceResourceId);
	}

	public List<Integer> getMedicalServicesResourceAuthorizedStates(Integer medicalServiceResourceId) {
		
		return medicalServiceResourceRepository.getMedicalServicesResourceAuthorizedStates(medicalServiceResourceId);
	}

	public void setMedicalServicesResourceState(Integer medicalServiceResourceId, Integer state) {
		
		medicalServiceResourceRepository.setMedicalServicesResourceState(medicalServiceResourceId, state);
		
	}



	
	
	

}
