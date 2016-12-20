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
@SequenceGenerator(name = "INC_MOVIL", sequenceName = "IDMOVIL")
@Table(name="MOVILES")
public class Mobile {
	
	@Id
	@Column(name = "IDMOVIL")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MOVIL")
	private Integer mobileId;
	
	@ManyToOne
	@JoinColumn(name = "IDEMPRESA")
	private Company company;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "ACTIVO")
	private char active;
	
	@Column(name = "ALIAS")
	private String alias;
	
	@ManyToOne
	@JoinColumn(name = "IDTIPOMOVIL")
	private MobileType mobileType;

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public MobileType getMobileType() {
		return mobileType;
	}

	public void setMobileType(MobileType mobileType) {
		this.mobileType = mobileType;
	}

	
}
