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
@SequenceGenerator(name = "INC_CABINA", sequenceName = "IDCABINA")
@Table(name="CABINAS")
public class Cabin {
	
	@Id
	@Column(name = "IDCABINA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_CABINA")
	private Integer cabinId;
	
	@ManyToOne
	@JoinColumn(name = "IDEMPRESA")
	private Company company;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "LETRA")
	private char letter;

	public Integer getCabinId() {
		return cabinId;
	}

	public void setCabinId(Integer cabinId) {
		this.cabinId = cabinId;
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

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

}
