package com.unidadcoronaria.prestaciones.service;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceDiagnostic;


public interface MedicalServiceDiagnosticService {
	
	public MedicalServiceDiagnostic save(Integer medicalServiceId, Integer diagnosticId);

}
