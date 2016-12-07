package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_GUARDIA", sequenceName = "IDGUARDIA")
@Table(name="GUARDIAS")
public class Guard {
	
	@Id
	@Column(name = "IDGUARDIA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_GUARDIA")
	private Integer guardId;
	
	@Column(name = "IDPRESTADOR")
	private Integer providerId;

	public Integer getGuardId() {
		return guardId;
	}

	public void setGuardId(Integer guardId) {
		this.guardId = guardId;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	

}
