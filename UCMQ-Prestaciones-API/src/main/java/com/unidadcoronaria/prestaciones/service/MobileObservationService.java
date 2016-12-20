package com.unidadcoronaria.prestaciones.service;

import com.unidadcoronaria.prestaciones.domain.MobileObservation;
import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.domain.dto.MobileObservationDTO;

public interface MobileObservationService {
	
	public MobileObservation save(Resource resource, MobileObservationDTO dto);

}
