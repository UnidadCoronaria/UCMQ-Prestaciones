package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_MOTIVOLLAMADOPRESTACIONES", sequenceName = "IDMOTIVOLLAMADOPRESTACIONES")
@Table(name="MOTIVOSDELLAMADOPRESTACIONES")
public class CallReasonMedicalService {
	
	@Id
	@Column(name = "IDMOTIVOLLAMADOPRESTACIONES")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MOTIVOLLAMADOPRESTACIONES")
	private Integer callReasonMedicalServiceId;
	
	@Column(name = "NOMBRE")
	private String name;

	public Integer getCallReasonMedicalServiceId() {
		return callReasonMedicalServiceId;
	}

	public void setCallReasonMedicalServiceId(Integer callReasonMedicalServiceId) {
		this.callReasonMedicalServiceId = callReasonMedicalServiceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
