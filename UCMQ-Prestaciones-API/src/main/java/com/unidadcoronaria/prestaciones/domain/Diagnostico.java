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
public class Diagnostico {
	
	@Id
	@Column(name = "IDDIAGNOSTICO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_DIAGNOSTICO")
	private Integer iddiagnostico;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "ACTIVO")
	private char activo;
	
	@Column(name = "NUMERO")
	private String numero;
	
	public Integer getIddiagnostico() {
		return iddiagnostico;
	}

	public void setIddiagnostico(Integer iddiagnostico) {
		this.iddiagnostico = iddiagnostico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
	
	
	
	

}
