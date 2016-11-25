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
@SequenceGenerator(name = "INC_PRESTACIONMEDICAMENTO", sequenceName = "IDPRESTACIONMEDICAMENTO")
@Table(name="PRESTACIONESMEDICAMENTOS")
public class MedicalServiceMedicament {
	
	@Id
	@Column(name = "IDPRESTACIONMEDICAMENTO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PRESTACIONMEDICAMENTO")
	private Integer medicalServiceMedicamentId;
	
	@ManyToOne
	@JoinColumn(name = "IDPRESTACIONRECURSO")
	private MedicalServiceResource medicalServiceResource;
	
	@ManyToOne
	@JoinColumn(name = "IDMEDICAMENTO")
	private Medicament medicament;
	
	@Column(name = "CANTIDAD")
	private Double amount;

	public Integer getMedicalServiceMedicamentId() {
		return medicalServiceMedicamentId;
	}

	public void setMedicalServiceMedicamentId(Integer medicalServiceMedicamentId) {
		this.medicalServiceMedicamentId = medicalServiceMedicamentId;
	}

	public MedicalServiceResource getMedicalServiceResource() {
		return medicalServiceResource;
	}

	public void setMedicalServiceResource(
			MedicalServiceResource medicalServiceResource) {
		this.medicalServiceResource = medicalServiceResource;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

}
