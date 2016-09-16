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
@SequenceGenerator(name = "INC_PRESTACIONRECURSO", sequenceName = "IDPRESTACIONRECURSO")
@Table(name="PRESTACIONESRECURSOS")
public class MedicalServiceResource {

	@Id
	@Column(name = "IDPRESTACIONRECURSO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PRESTACIONRECURSO")
	private Integer MedicalServiceResourceId;
	
	@ManyToOne
	@JoinColumn(name = "IDPRESTACION")
	private MedicalService medicalService;
	
	@ManyToOne
	@JoinColumn(name = "IDRECURSO")
	private Resource resource;

	public Integer getMedicalServiceResourceId() {
		return MedicalServiceResourceId;
	}

	public void setMedicalServiceResourceId(Integer medicalServiceResourceId) {
		MedicalServiceResourceId = medicalServiceResourceId;
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
}
