package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Diagnostic;
import com.unidadcoronaria.prestaciones.repository.DiagnosticRepository;

@Component("diagnosticService")
@Transactional
public class DiagnosticServiceImpl implements DiagnosticService {
	
	final static Logger logger = Logger.getLogger(MedicamentServiceImpl.class);
	
	@Autowired
    private DiagnosticRepository diagnosticRepository;

	@Override
	public List<Diagnostic> getDiagnosticList() {
		
		return diagnosticRepository.getActivesDiagnostic();
		
	}

}
