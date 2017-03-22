package com.unidadcoronaria.prestaciones.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.MedicalService;
import com.unidadcoronaria.prestaciones.domain.MedicalServiceCallReason;
import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.domain.dto.CloseMedicalServiceResourceDTO;
import com.unidadcoronaria.prestaciones.domain.dto.MedicalServiceResourceDTO;
import com.unidadcoronaria.prestaciones.exception.MedicalServiceNotFoundException;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceCallReasonRepository;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceRepository;
import com.unidadcoronaria.prestaciones.repository.MedicalServiceResourceRepository;

@Component("medicalServiceResource")
@Transactional
public class MedicalServiceResourceServiceImpl implements MedicalServiceResourceService {
	
	final static Logger logger = Logger.getLogger(MedicalServiceResourceServiceImpl.class);
	
	@Autowired
    private MedicalServiceResourceRepository medicalServiceResourceRepository;
	
	@Autowired
    private MedicalServiceMedicamentService medicalServiceMedicamentService;
	
	@Autowired
	private MedicalServiceDiagnosticService medicalServiceDiagnosticService;
	
	@Autowired
    private MedicalServiceService medicalServiceService;
	
	@Autowired
    private MedicalServiceRepository medicalServiceRepository;
	
	@Autowired
    private MedicalServiceCallReasonRepository medicalServiceCallReasonRepository;
	
	public List<MedicalServiceResource> getMedicalServiceResourceList(Integer resourceId) {
		try {

			List<MedicalServiceResource> medicalServiceResourceList = new ArrayList<MedicalServiceResource>();
			medicalServiceResourceList = medicalServiceResourceRepository.findByResourceId(resourceId);

			for (int i = 0; i < medicalServiceResourceList.size(); i++) {
				Integer currentState = getMedicalServicesResourceCurrentState(medicalServiceResourceList.get(i).getMedicalServiceResourceId());
				medicalServiceResourceList.get(i).setCurrentState(currentState);
				List<Integer> authorizedStates = getMedicalServicesResourceAuthorizedStates(medicalServiceResourceList.get(i).getMedicalServiceResourceId());
				medicalServiceResourceList.get(i).setAuthorizedStates(authorizedStates);
				List<MedicalServiceCallReason> medicalServiceCallReasonList = medicalServiceCallReasonRepository.getMedicalServiceCallReasonByMedicalServiceId(medicalServiceResourceList.get(i).getMedicalService().getMedicalServiceId());
				medicalServiceResourceList.get(i).setMedicalServiceCallReason(medicalServiceCallReasonList);
				medicalServiceResourceList.get(i).setPlanDetail(medicalServiceResourceRepository.getPlanDetail(medicalServiceResourceList.get(i).getMedicalService().getMedicalServiceId()));
			}
			return medicalServiceResourceList;
		} catch (Exception e) {
			throw new MedicalServiceNotFoundException("MedicalServiceResource Database query error");
		}
	}
	
	public MedicalServiceResource getMedicalServiceResource(Integer medicalServiceResourceId) {
		MedicalServiceResource medicalServiceResource = new MedicalServiceResource();
		medicalServiceResource = medicalServiceResourceRepository.findByMedicalServiceResourceId(medicalServiceResourceId);
		Integer currentState = getMedicalServicesResourceCurrentState(medicalServiceResourceId);
		medicalServiceResource.setCurrentState(currentState);
		List<Integer> authorizedStates =  getMedicalServicesResourceAuthorizedStates(medicalServiceResourceId);
		medicalServiceResource.setAuthorizedStates(authorizedStates);
		List<MedicalServiceCallReason> medicalServiceCallReasonList = medicalServiceCallReasonRepository.getMedicalServiceCallReasonByMedicalServiceId(medicalServiceResource.getMedicalService().getMedicalServiceId());
		medicalServiceResource.setMedicalServiceCallReason(medicalServiceCallReasonList);
		medicalServiceResource.setPlanDetail(medicalServiceResourceRepository.getPlanDetail(medicalServiceResource.getMedicalService().getMedicalServiceId()));
		
		return medicalServiceResource;
	}
	
	public Integer getMedicalServicesResourceCurrentState(Integer medicalServiceResourceId) {
		
		return medicalServiceResourceRepository.getMedicalServiceResourceCurrentState(medicalServiceResourceId);
	}

	public List<Integer> getMedicalServicesResourceAuthorizedStates(Integer medicalServiceResourceId) {
		
		return medicalServiceResourceRepository.getMedicalServiceResourceAuthorizedStates(medicalServiceResourceId);
	}

	public void setMedicalServicesResourceState(MedicalServiceResourceDTO dto) {
		
		Integer medicalServiceTransferId;
		medicalServiceTransferId = medicalServiceResourceRepository.getMedicalServiceTransferId(dto.getMedicalServiceResourceId());
		
		if (medicalServiceTransferId != null) {
			
			medicalServiceResourceRepository.setMedicalServiceTransferState(medicalServiceTransferId, dto.getState(), dto.getLatitude(), dto.getLongitude());
			
		} else {
			
			medicalServiceResourceRepository.setMedicalServiceResourceState(dto.getMedicalServiceResourceId(), dto.getState(), dto.getLatitude(), dto.getLongitude());
			
		}
				
	}
	
	public List<MedicalServiceResource> getAttendedMedicalServicesList(Integer guardId) {
		
		try {
		    List<MedicalServiceResource> medicalServiceResourceList = new ArrayList<MedicalServiceResource>();
		    List<Integer> medicalServiceResourceIdList;
		    medicalServiceResourceIdList = medicalServiceResourceRepository.getAttendedMedicalServiceResource(guardId);
		
		    for(int i=0;i<medicalServiceResourceIdList.size();i++){	
			    MedicalServiceResource medicalServiceResource = new MedicalServiceResource();
			    medicalServiceResource = getMedicalServiceResource(medicalServiceResourceIdList.get(i));
			    medicalServiceResourceList.add(medicalServiceResource);	
		    }
		 
		    return medicalServiceResourceList;
		}catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error al consultar la DB");	
		}
		
	}
	
	public void closeMedicalServiceResource(CloseMedicalServiceResourceDTO closeMedicalServiceResourceDTO) {
		try {
			
			/*MedicalServiceId*/
			Integer medicalServiceId;
			medicalServiceId = getMedicalServicesId(closeMedicalServiceResourceDTO.getMedicalServiceResourceDTO().getMedicalServiceResourceId());
			
			/*Diagnostic*/
			for(int i=0;i<closeMedicalServiceResourceDTO.getListDiagnosticId().size();i++){
				medicalServiceDiagnosticService.save(medicalServiceId, closeMedicalServiceResourceDTO.getListDiagnosticId().get(i));
			}
			
			/*Medicament*/
			for(int i=0;i<closeMedicalServiceResourceDTO.getListMedicalServiceMedicamentDTO().size();i++){				
				medicalServiceMedicamentService.save(closeMedicalServiceResourceDTO.getListMedicalServiceMedicamentDTO().get(i));				
			}
			
			/*ECG*/
			if (closeMedicalServiceResourceDTO.getEcg() == 'T') {
				MedicalService medicalService = medicalServiceService.getMedicalServiceById(medicalServiceId);
				medicalService.setEcg(closeMedicalServiceResourceDTO.getEcg());
				medicalServiceRepository.save(medicalService);
			}
			
			/*Copayment*/
			if (closeMedicalServiceResourceDTO.getCopaymentPaid() == 'T') {
				MedicalService medicalService = medicalServiceService.getMedicalServiceById(medicalServiceId);
				medicalService.setCopaymentPaid(closeMedicalServiceResourceDTO.getCopaymentPaid());
				medicalServiceRepository.save(medicalService);
			}
			
			/*Close MedicalService*/
			setMedicalServicesResourceState(closeMedicalServiceResourceDTO.getMedicalServiceResourceDTO());
	
		}catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error closing Medical Service - DB");	
		}
		
	}

	@Override
	public Integer getMedicalServicesId(Integer medicalServiceResourceId) {
		return medicalServiceResourceRepository.getMedicalServicesId(medicalServiceResourceId);
	}
	

}
