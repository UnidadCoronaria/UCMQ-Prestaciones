package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceCallReason;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceCallReasonRepository;

@Component("medicalServiceCallReasonService")
@Transactional
public class MedicalServiceCallReasonServiceImpl implements MedicalServiceCallReasonService {
	
	final static Logger logger = Logger.getLogger(MedicalServiceCallReasonServiceImpl.class);
	
	@Autowired
    private MedicalServiceCallReasonRepository medicalServiceCallReasonRepository;

	@Override
	public List<MedicalServiceCallReason> getMedicalServiceCallReasonList(Integer medicalServiceId) {
		
		return medicalServiceCallReasonRepository.getMedicalServiceCallReasonByMedicalServiceId(medicalServiceId);
	}

}
