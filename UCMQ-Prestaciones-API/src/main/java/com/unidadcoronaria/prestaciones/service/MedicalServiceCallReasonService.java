package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceCallReason;

public interface MedicalServiceCallReasonService {
	
	public List<MedicalServiceCallReason> getMedicalServiceCallReasonList(Integer medicalServiceId);

}
