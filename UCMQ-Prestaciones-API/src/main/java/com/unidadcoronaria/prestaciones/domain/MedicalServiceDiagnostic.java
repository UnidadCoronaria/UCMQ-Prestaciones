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
@SequenceGenerator(name = "INC_PRESTACIONDIAGNOSTICO", sequenceName = "IDPRESTACIONDIAGNOSTICO")
@Table(name="PRESTACIONESDIAGNOSTICOS")
public class MedicalServiceDiagnostic {
	
	@Id
	@Column(name = "IDPRESTACIONDIAGNOSTICO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PRESTACIONDIAGNOSTICO")
	private Integer medicalServiceDiagnosticId;
	
	@ManyToOne
	@JoinColumn(name = "IDPRESTACION")
	private MedicalService medicalService;
	
	@ManyToOne
	@JoinColumn(name = "IDDIAGNOSTICO")
	private Diagnostic diagnostic;

	public Integer getMedicalServiceDiagnosticId() {
		return medicalServiceDiagnosticId;
	}

	public void setMedicalServiceDiagnosticId(Integer medicalServiceDiagnosticId) {
		this.medicalServiceDiagnosticId = medicalServiceDiagnosticId;
	}

	public MedicalService getMedicalService() {
		return medicalService;
	}

	public void setMedicalService(MedicalService medicalService) {
		this.medicalService = medicalService;
	}

	public Diagnostic getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}
	
	

}
