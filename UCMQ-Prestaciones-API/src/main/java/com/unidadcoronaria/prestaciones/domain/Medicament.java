package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "INC_MEDICAMENTO", sequenceName = "IDMEDICAMENTO")
@Table(name="MEDICAMENTOS")
public class Medicament {
	
	@Id
	@Column(name = "IDMEDICAMENTO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MEDICAMENTO")
	private Integer medicamentId;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "NUMERO")
	private String number;
	
	@Column(name = "ACTIVO")
	private char active;
	
	@Column(name = "TIPO")
	private String type;

	public Integer getMedicamentId() {
		return medicamentId;
	}

	public void setMedicamentId(Integer medicamentId) {
		this.medicamentId = medicamentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	

}
