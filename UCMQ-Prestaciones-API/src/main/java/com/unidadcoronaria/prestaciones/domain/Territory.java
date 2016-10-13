package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_TERRITORIO", sequenceName = "IDTERRITORIO")
@Table(name="TERRITORIOS")
public class Territory {
	
	@Id
	@Column(name = "IDTERRITORIO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_TERRITORIO")
	private Integer territoryId;
	
	@Column(name = "NOMBRE")
	private String name;

	public Integer getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(Integer territoryId) {
		this.territoryId = territoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
