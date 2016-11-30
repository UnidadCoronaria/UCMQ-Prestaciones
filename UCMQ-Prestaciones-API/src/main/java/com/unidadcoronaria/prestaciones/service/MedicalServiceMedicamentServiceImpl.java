package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceMedicament;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceMedicamentRepository;


@Component("medicalServiceMedicament")
@Transactional
public class MedicalServiceMedicamentServiceImpl implements MedicalServiceMedicamentService  {
	
	final static Logger logger = Logger.getLogger(MedicalServiceServiceImpl.class);
	
	@Autowired
    private MedicalServiceMedicamentRepository medicalServiceMedicamentRepository;

	public MedicalServiceMedicament save(MedicalServiceMedicament medicalServiceMedicament) {
				
		return medicalServiceMedicamentRepository.save(medicalServiceMedicament);
		
	}
	

}
