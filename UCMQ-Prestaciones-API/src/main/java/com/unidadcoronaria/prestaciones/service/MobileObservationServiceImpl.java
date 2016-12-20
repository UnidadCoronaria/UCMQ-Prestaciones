package com.unidadcoronaria.prestaciones.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Guard;
import com.unidadcoronaria.prestaciones.domain.MobileObservation;
import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.domain.TypeMobileObservation;
import com.unidadcoronaria.prestaciones.domain.dto.MobileObservationDTO;
import com.unidadcoronaria.prestaciones.exception.MedicalServiceNotFoundException;
import com.unidadcoronaria.prestaciones.repository.MobileObservationRepository;

@Component("mobileObservation")
@Transactional
public class MobileObservationServiceImpl implements MobileObservationService {
	
    final static Logger logger = Logger.getLogger(MobileObservationServiceImpl.class);
	
	@Autowired
    private MobileObservationRepository mobileObservationRepository;

	@Override
	public MobileObservation save(Resource resource, MobileObservationDTO dto) {
		try {
			MobileObservation mobileObservation = new MobileObservation();
			TypeMobileObservation typeMobileObservation = new TypeMobileObservation();
			typeMobileObservation.setTypeMobileObservationId(dto.getTypeMobileObservationId());
			Guard guard = new Guard();
			guard.setGuardId(dto.getGuardId());

			SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String timeAsString = timeFormatter.format(date);

			mobileObservation.setMobile(resource.getMobile());
			mobileObservation.setTypeMobileObservation(typeMobileObservation);
			mobileObservation.setGuard(guard);
			mobileObservation.setObservation(dto.getObservation());
			mobileObservation.setDateTime(dateFormatter.parse(dateFormatter.format(date)));
			mobileObservation.setDate(dateFormatter.parse(dateFormatter.format(date)));
			mobileObservation.setTime(timeAsString);

			return mobileObservationRepository.save(mobileObservation);
		} catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error saving Mobile Observation into DB");
		}
	}

}
