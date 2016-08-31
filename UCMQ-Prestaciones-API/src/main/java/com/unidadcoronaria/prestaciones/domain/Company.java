package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "INC_EMPRESA", sequenceName = "IDEMPRESA")
@Table(name="EMPRESAS")
public class Company {
	
	@Id
	@Column(name = "IDEMPRESA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_EMPRESA")
	private Integer companyId;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "NOMBREDEFANTASIA")
	private String fantasyName;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	

}
