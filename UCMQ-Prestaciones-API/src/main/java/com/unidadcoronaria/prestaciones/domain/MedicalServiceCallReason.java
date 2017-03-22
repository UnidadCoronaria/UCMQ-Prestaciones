package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_PRESTACIONMOTIVOLLAMADO", sequenceName = "IDPRESTACIONMOTIVOLLAMADO")
@Table(name="PRESTACIONESMOTIVOSDELLAMADO")
public class MedicalServiceCallReason {
	
	@Id
	@Column(name = "IDPRESTACIONMOTIVOLLAMADO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PRESTACIONMOTIVOLLAMADO")
	private Integer medicalServiceCallReasonId;
	
	@ManyToOne
	@JoinColumn(name = "IDPRESTACION")
	private MedicalService medicalService;
	
	@ManyToOne
	@JoinColumn(name = "IDMOTIVOLLAMADOPRESTACIONES")
	private CallReasonMedicalService callReasonMedicalService;

	public Integer getMedicalServiceCallReasonId() {
		return medicalServiceCallReasonId;
	}

	public void setMedicalServiceCallReasonId(Integer medicalServiceCallReasonId) {
		this.medicalServiceCallReasonId = medicalServiceCallReasonId;
	}

	public MedicalService getMedicalService() {
		return medicalService;
	}

	public void setMedicalService(MedicalService medicalService) {
		this.medicalService = medicalService;
	}

	public CallReasonMedicalService getCallReasonMedicalService() {
		return callReasonMedicalService;
	}

	public void setCallReasonMedicalService(
			CallReasonMedicalService callReasonMedicalService) {
		this.callReasonMedicalService = callReasonMedicalService;
	}

}
