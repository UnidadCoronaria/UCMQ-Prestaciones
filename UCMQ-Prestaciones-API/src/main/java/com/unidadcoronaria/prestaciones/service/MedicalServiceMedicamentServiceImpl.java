package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceMedicament;


@Component("medicalServiceMedicament")
@Transactional
public class MedicalServiceMedicamentServiceImpl implements MedicalServiceMedicamentService  {
	
	final static Logger logger = Logger.getLogger(MedicalServiceServiceImpl.class);

	public void save(MedicalServiceMedicament medicalServiceMedicament) {

        save(medicalServiceMedicament);		
	}
	

}
