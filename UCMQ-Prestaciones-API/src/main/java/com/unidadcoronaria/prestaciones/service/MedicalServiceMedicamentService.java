package com.unidadcoronaria.prestaciones.service;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceMedicament;
import com.unidadcoronaria.prestaciones.domain.dto.MedicalServiceMedicamentDTO;

public interface MedicalServiceMedicamentService {
	
	public MedicalServiceMedicament save(MedicalServiceMedicamentDTO dto);

}
