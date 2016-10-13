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
@SequenceGenerator(name = "INC_DOMICILIOPRESTACION", sequenceName = "IDDOMICILIOPRESTACION")
@Table(name="DOMICILIOSPRESTACIONES")
public class AddressMedicalService {
	
	@Id
	@Column(name = "IDDOMICILIOPRESTACION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_DOMICILIOPRESTACION")
	private Integer addressMedicalServiceId;
	
	@Column(name = "NOMBRECALLE")
	private String street;
	
	@Column(name = "ALTURA")
	private Integer number;
	
	@Column(name = "NOMBREENTRECALLE1")
	private String street1;
	
	@Column(name = "NOMBREENTRECALLE2")
	private String street2;
	
	@ManyToOne
	@JoinColumn(name = "IDLOCALIDAD")
	private Territory territory;
	
	@Column(name = "UBICACION_LATITUD")
	private Double latitude;
	
	@Column(name = "UBICACION_LONGITUD")
	private Double longitude;

	public Integer getAddressMedicalServiceId() {
		return addressMedicalServiceId;
	}

	public void setAddressMedicalServiceId(Integer addressMedicalServiceId) {
		this.addressMedicalServiceId = addressMedicalServiceId;
	}



}
