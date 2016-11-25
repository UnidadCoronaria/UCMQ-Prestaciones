package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;

public interface MedicalServiceResourceService {
	
	List<MedicalServiceResource> getMedicalServiceResourceList(Integer resourceId);
	
	MedicalServiceResource getMedicalServiceResource(Integer medicalServiceResourceId);
	
	Integer getMedicalServicesResourceCurrentState(Integer medicalServiceResourceId);
	
	List<Integer> getMedicalServicesResourceAuthorizedStates(Integer medicalServiceResourceId);
	
	void setMedicalServicesResourceState(Integer medicalServiceResourceId, Integer state);

}
