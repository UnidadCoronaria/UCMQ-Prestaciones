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
@SequenceGenerator(name = "INC_RECURSO", sequenceName = "IDRECURSO")
@Table(name="RECURSOS")
public class Resource {
	
	@Id
	@Column(name = "IDRECURSO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_RECURSO")
	private Integer resourceId;
	
	@ManyToOne
	@JoinColumn(name = "IDMOVIL")
	private Mobile mobile;
	
	@Column(name = "FUERADESERVICIO")
	private char outOfService;

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public char getOutOfService() {
		return outOfService;
	}

	public void setOutOfService(char outOfService) {
		this.outOfService = outOfService;
	}

	

	
	
	

}
