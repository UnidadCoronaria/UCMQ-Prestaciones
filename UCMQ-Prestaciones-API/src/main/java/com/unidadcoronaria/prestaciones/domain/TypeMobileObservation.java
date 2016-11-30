package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_TIPOOBSERVACIONMOVIL", sequenceName = "IDTIPOOBSERVACIONMOVIL")
@Table(name="TIPOSDEOBSERVACIONESMOVILES")
public class TypeMobileObservation {
	
	@Id
	@Column(name = "IDTIPOOBSERVACIONMOVIL")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_TIPOOBSERVACIONMOVIL")
	private Integer typeMobileObservationId;
	
	@Column(name = "NOMBRE")
	private String name;

	public Integer getTypeMobileObservationId() {
		return typeMobileObservationId;
	}

	public void setTypeMobileObservationId(Integer typeMobileObservationId) {
		this.typeMobileObservationId = typeMobileObservationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
