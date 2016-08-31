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
public class Recurso {
	
	@Id
	@Column(name = "IDRECURSO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_RECURSO")
	private Integer idrecurso;
	
	@ManyToOne
	@JoinColumn(name = "IDMOVIL")
	private Movil movil;
	
	@Column(name = "FUERADESERVICIO")
	private char fueradeservicio;

	public Integer getIdrecurso() {
		return idrecurso;
	}

	public void setIdrecurso(Integer idrecurso) {
		this.idrecurso = idrecurso;
	}

	public Movil getMovil() {
		return movil;
	}

	public void setMovil(Movil movil) {
		this.movil = movil;
	}

	public char getFueradeservicio() {
		return fueradeservicio;
	}

	public void setFueradeservicio(char fueradeservicio) {
		this.fueradeservicio = fueradeservicio;
	}
	
	
	

}
