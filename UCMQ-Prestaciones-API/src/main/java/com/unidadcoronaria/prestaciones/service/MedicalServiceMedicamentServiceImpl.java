package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceMedicament;
import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.domain.Medicament;
import com.unidadcoronaria.prestaciones.domain.dto.MedicalServiceMedicamentDTO;
import com.unidadcoronaria.prestaciones.exception.MedicalServiceNotFoundException;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceMedicamentRepository;


@Component("medicalServiceMedicament")
@Transactional
public class MedicalServiceMedicamentServiceImpl implements MedicalServiceMedicamentService  {
	
	final static Logger logger = Logger.getLogger(MedicalServiceMedicamentServiceImpl.class);
	
	@Autowired
    private MedicalServiceMedicamentRepository medicalServiceMedicamentRepository;

	//public MedicalServiceMedicament save(MedicalServiceMedicament medicalServiceMedicament) {
	public MedicalServiceMedicament save(MedicalServiceMedicamentDTO dto) {
		try {
			MedicalServiceMedicament medicalServiceMedicament = new MedicalServiceMedicament();
			MedicalServiceResource medicalServiceResource = new MedicalServiceResource();
			Medicament medicament = new Medicament();

			medicalServiceResource.setMedicalServiceResourceId(dto.getMedicalServiceResourceId());
			medicament.setMedicamentId(dto.getMedicamentId());

			medicalServiceMedicament.setMedicalServiceResource(medicalServiceResource);
			medicalServiceMedicament.setMedicament(medicament);
			medicalServiceMedicament.setAmount(dto.getAmount());
			return medicalServiceMedicamentRepository.save(medicalServiceMedicament);
		} catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error saving Medical Service Medicament into DB");
		}
		
	}
	

}
