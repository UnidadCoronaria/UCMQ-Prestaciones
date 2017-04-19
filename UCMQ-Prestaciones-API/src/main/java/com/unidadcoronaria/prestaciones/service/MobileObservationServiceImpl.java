package com.unidadcoronaria.prestaciones.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Guard;
import com.unidadcoronaria.prestaciones.domain.Mobile;
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
	public void save(Resource resource, Integer guardId, List<MobileObservationDTO> dto) {
		try {
			
			for(int i=0;i<dto.size();i++){	
				if (!dto.get(i).getState())  {
					MobileObservation mobileObservation = new MobileObservation();
					TypeMobileObservation typeMobileObservation = new TypeMobileObservation();
					typeMobileObservation.setTypeMobileObservationId(dto.get(i).getTypeMobileObservationId());
					Guard guard = new Guard();
					guard.setGuardId(guardId);
					Mobile mobile = new Mobile();
					mobile.setMobileId(resource.getMobile().getMobileId());

					SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
					SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date();
					String timeAsString = timeFormatter.format(date);

					mobileObservation.setMobile(mobile);
					mobileObservation.setTypeMobileObservation(typeMobileObservation);
					mobileObservation.setGuard(guard);
					mobileObservation.setObservation(dto.get(i).getObservation());
					mobileObservation.setDateTime(dateFormatter.parse(dateFormatter.format(date)));
					mobileObservation.setDate(dateFormatter.parse(dateFormatter.format(date)));
					mobileObservation.setTime(timeAsString);

					mobileObservationRepository.save(mobileObservation);	
				}
						
			}
			
		} catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error saving Mobile Observation into DB");
		}
	}

}
