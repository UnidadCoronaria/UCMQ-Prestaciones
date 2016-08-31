package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "INC_TIPOMOVIL", sequenceName = "IDTIPOMOVIL")
@Table(name="TIPOSDEMOVILES")
public class MobileType {
	
	@Id
	@Column(name = "IDTIPOMOVIL")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_TIPOMOVIL")
	private Integer mobileTypeId;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "ALIAS")
	private String alias;

	public Integer getMobileTypeId() {
		return mobileTypeId;
	}

	public void setMobileTypeId(Integer mobileTypeId) {
		this.mobileTypeId = mobileTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	

}
