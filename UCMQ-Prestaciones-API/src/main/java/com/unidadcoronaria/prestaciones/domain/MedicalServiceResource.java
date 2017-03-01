package com.unidadcoronaria.prestaciones.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@SequenceGenerator(name = "INC_PRESTACIONRECURSO", sequenceName = "IDPRESTACIONRECURSO")
@Table(name="PRESTACIONESRECURSOS")
public class MedicalServiceResource {

	@Id
	@Column(name = "IDPRESTACIONRECURSO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PRESTACIONRECURSO")
	private Integer medicalServiceResourceId;
	
	@ManyToOne
	@JoinColumn(name = "IDPRESTACION")
	private MedicalService medicalService;
	
	@ManyToOne
	@JoinColumn(name = "IDRECURSO")
	private Resource resource;
	
	@Column(name = "CANCELADO")
	private Integer canceled;
	
	@Column(name = "PRESTACIONCERRADA")
	private char closedMedicalService;
	
	@Transient
	private Integer currentState;
	
	@Transient
	private List<Integer> authorizedStates;

	public Integer getMedicalServiceResourceId() {
		return medicalServiceResourceId;
	}

	public void setMedicalServiceResourceId(Integer medicalServiceResourceId) {
		this.medicalServiceResourceId = medicalServiceResourceId;
	}

	public MedicalService getMedicalService() {
		return medicalService;
	}

	public void setMedicalService(MedicalService medicalService) {
		this.medicalService = medicalService;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Integer getCanceled() {
		return canceled;
	}

	public void setCanceled(Integer canceled) {
		this.canceled = canceled;
	}

	public char getClosedMedicalService() {
		return closedMedicalService;
	}

	public void setClosedMedicalService(char closedMedicalService) {
		this.closedMedicalService = closedMedicalService;
	}

	public Integer getCurrentState() {
		return currentState;
	}

	public void setCurrentState(Integer currentState) {
		this.currentState = currentState;
	}

	public List<Integer> getAuthorizedStates() {
		return authorizedStates;
	}

	public void setAuthorizedStates(List<Integer> authorizedStates) {
		this.authorizedStates = authorizedStates;
	}

	
}