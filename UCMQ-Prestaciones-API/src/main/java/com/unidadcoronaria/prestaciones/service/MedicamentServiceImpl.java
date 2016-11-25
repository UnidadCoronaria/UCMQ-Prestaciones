package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Medicament;
import com.unidadcoronaria.prestaciones.repository.MedicamentRepository;


@Component("medicament")
@Transactional
public class MedicamentServiceImpl implements MedicamentService {
	
final static Logger logger = Logger.getLogger(MedicalServiceServiceImpl.class);
	
	@Autowired
    private MedicamentRepository medicamentRepository;

	@Override
	public List<Medicament> getMedicamentList() {
		
		return medicamentRepository.getActivesMedicaments();
		
	}
	
	

}
