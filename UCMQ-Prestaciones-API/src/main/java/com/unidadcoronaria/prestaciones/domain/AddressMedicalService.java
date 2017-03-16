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
	
	@Column(name = "REFERENCIAS")
	private String information;
	
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



}
