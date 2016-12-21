package com.unidadcoronaria.prestaciones.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.domain.dto.MedicalServiceResourceDTO;
import com.unidadcoronaria.prestaciones.exception.MedicalServiceNotFoundException;
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

	public void setMedicalServicesResourceState(MedicalServiceResourceDTO dto) {
		
		medicalServiceResourceRepository.setMedicalServicesResourceState(dto.getMedicalServiceResourceId(), dto.getState());
		
	}
	
	public List<MedicalServiceResource> getAttendedMedicalServicesList(Integer guardId) {
		
		try {
		    List<MedicalServiceResource> medicalServiceResourceList = new ArrayList<MedicalServiceResource>();
		    List<Integer> medicalServiceResourceIdList;
		    medicalServiceResourceIdList = medicalServiceResourceRepository.getAttendedMedicalServicesResource(guardId);
		
		    for(int i=0;i<medicalServiceResourceIdList.size();i++){	
			    MedicalServiceResource medicalServiceResource = new MedicalServiceResource();
			    medicalServiceResource = getMedicalServiceResource(medicalServiceResourceIdList.get(i)); 
			    medicalServiceResourceList.add(medicalServiceResource);	
		    }
		 
		    return medicalServiceResourceList;
		}catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error al consultar la DB");	
		}
		
	}



	
	
	

}
