package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_DOMICILIOPRESTACION", sequenceName = "IDDOMICILIOPRESTACION")
@Table(name="DOMICILIOSPRESTACIONES")
public class DomicilioPrestacion {
	
	@Id
	@Column(name = "IDDOMICILIOPRESTACION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_DOMICILIOPRESTACION")
	private Integer iddomicilioprestacion;

	public Integer getIddomicilioprestacion() {
		return iddomicilioprestacion;
	}

	public void setIddomicilioprestacion(Integer iddomicilioprestacion) {
		this.iddomicilioprestacion = iddomicilioprestacion;
	}
	
	

}
