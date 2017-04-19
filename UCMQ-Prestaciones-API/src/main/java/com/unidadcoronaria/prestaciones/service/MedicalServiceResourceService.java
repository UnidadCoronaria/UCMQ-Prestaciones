package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.domain.dto.CloseMedicalServiceResourceDTO;
import com.unidadcoronaria.prestaciones.domain.dto.MedicalServiceResourceDTO;

public interface MedicalServiceResourceService {
	
	List<MedicalServiceResource> getMedicalServiceResourceList(Integer resourceId);
	
	MedicalServiceResource getMedicalServiceResource(Integer medicalServiceResourceId);
	
	Integer getMedicalServicesResourceCurrentState(Integer medicalServiceResourceId);
	
	List<Integer> getMedicalServicesResourceAuthorizedStates(Integer medicalServiceResourceId);
	
	void setMedicalServicesResourceState(MedicalServiceResourceDTO dto);
	
	public List<MedicalServiceResource> getAttendedMedicalServicesList(Integer guardId);
	
	public void closeMedicalServiceResource(CloseMedicalServiceResourceDTO closeMedicalServiceResourceDTO);
	
	Integer getMedicalServicesId(Integer medicalServiceResourceId);
	
	public void setMedicalServiceResourceReceived(Integer medicalServiceResourceId, char received);

}
