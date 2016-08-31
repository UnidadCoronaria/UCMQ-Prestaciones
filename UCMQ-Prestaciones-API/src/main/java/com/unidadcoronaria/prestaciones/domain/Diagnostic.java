package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "INC_DIAGNOSTICO", sequenceName = "IDDIAGNOSTICO")
@Table(name="DIAGNOSTICOS")
public class Diagnostic {
	
	@Id
	@Column(name = "IDDIAGNOSTICO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_DIAGNOSTICO")
	private Integer diagnosticId;  
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "DESCRIPCION")  
	private String description;
	
	@Column(name = "ACTIVO")
	private char active;
	
	@Column(name = "NUMERO")
	private String number;

	public Integer getDiagnosticId() {
		return diagnosticId;
	}

	public void setDiagnosticId(Integer diagnosticId) {
		this.diagnosticId = diagnosticId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	
	
	
	
	
	

}
