package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MobileObservation;
import com.unidadcoronaria.prestaciones.repository.MobileObservationRepository;

@Component("mobileObservation")
@Transactional
public class MobileObservationServiceImpl implements MobileObservationService {
	
    final static Logger logger = Logger.getLogger(MobileObservationServiceImpl.class);
	
	@Autowired
    private MobileObservationRepository mobileObservationRepository;

	@Override
	public MobileObservation save(MobileObservation mobileObservation) {
		
		return mobileObservationRepository.save(mobileObservation);
	}

}
