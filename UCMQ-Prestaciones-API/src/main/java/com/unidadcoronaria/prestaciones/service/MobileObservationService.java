package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.domain.dto.MobileObservationDTO;

public interface MobileObservationService {
	
	public void save(Resource resource, Integer guardId, List<MobileObservationDTO> dto);

}
