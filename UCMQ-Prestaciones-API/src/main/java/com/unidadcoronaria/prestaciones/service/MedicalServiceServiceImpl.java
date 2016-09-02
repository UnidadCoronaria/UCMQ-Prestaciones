package com.unidadcoronaria.prestaciones.service;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalService;

/**
 * @author AGUSTIN.BALA
 *
 */

@Component("medicalService")
@Transactional
public class MedicalServiceServiceImpl implements MedicalServiceService {

	final static Logger logger = Logger.getLogger(MedicalServiceServiceImpl.class);

	@Override
	public List<MedicalService> getMedicalServiceList() {
		return Arrays.asList(new MedicalService());
	}	
	

}

