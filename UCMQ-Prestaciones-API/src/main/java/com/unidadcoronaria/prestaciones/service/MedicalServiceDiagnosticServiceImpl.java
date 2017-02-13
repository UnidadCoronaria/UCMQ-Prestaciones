package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Diagnostic;
import com.unidadcoronaria.prestaciones.domain.MedicalService;
import com.unidadcoronaria.prestaciones.domain.MedicalServiceDiagnostic;
import com.unidadcoronaria.prestaciones.exception.MedicalServiceNotFoundException;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceDiagnosticRepository;

@Component("medicalServiceDiagnostic")
@Transactional
public class MedicalServiceDiagnosticServiceImpl implements MedicalServiceDiagnosticService {

    final static Logger logger = Logger.getLogger(MedicalServiceDiagnosticServiceImpl.class);
	
	@Autowired
    private MedicalServiceDiagnosticRepository medicalServiceDiagnosticRepository;
	
	
	public MedicalServiceDiagnostic save(Integer medicalServiceId, Integer diagnosticId) {
		
		try {
		    MedicalServiceDiagnostic medicalServiceDiagnostic = new MedicalServiceDiagnostic();
		    Diagnostic diagnostic = new Diagnostic();
		    MedicalService medicalService = new MedicalService();
		
		    diagnostic.setDiagnosticId(diagnosticId);
		    medicalService.setMedicalServiceId(medicalServiceId);
		    medicalServiceDiagnostic.setDiagnostic(diagnostic);
		    medicalServiceDiagnostic.setMedicalService(medicalService);
		
		    return medicalServiceDiagnosticRepository.save(medicalServiceDiagnostic);
		} catch(Exception e) {
			throw new MedicalServiceNotFoundException("Error al guardar prestación diagnostico en la DB");    	
		}
		
	}




}
