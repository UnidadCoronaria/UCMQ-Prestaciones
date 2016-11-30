package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.TypeMobileObservation;
import com.unidadcoronaria.prestaciones.repository.TypeMobileObservationRepository;


@Component("typeMobileObservationService")
@Transactional
public class TypeMobileObservationServiceImpl implements TypeMobileObservationService  {

	final static Logger logger = Logger.getLogger(TypeMobileObservationServiceImpl.class);
	
	@Autowired
    private TypeMobileObservationRepository typeMobileObservationRepository;

	@Override
	public List<TypeMobileObservation> getTypeMobileObservationList() {
		
		return typeMobileObservationRepository.getTypeMobileObservationList();
	}

}
