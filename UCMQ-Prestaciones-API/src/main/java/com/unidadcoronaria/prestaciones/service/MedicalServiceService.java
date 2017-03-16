package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.MedicalService;
import com.unidadcoronaria.prestaciones.domain.Resource;

public interface MedicalServiceService {
	
	List<MedicalService> getMedicalServiceList(Integer resourceId);
	
	List<MedicalService> getPrestacionesList();
	
	Resource getResourceIdByImei(String imei);
	
	public MedicalService getMedicalServiceById(Integer medicalServiceId);
	
}
