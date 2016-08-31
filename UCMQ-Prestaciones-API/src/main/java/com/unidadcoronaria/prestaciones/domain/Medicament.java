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
public class Medicamento {
	
	@Id
	@Column(name = "IDMEDICAMENTO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MEDICAMENTO")
	private Integer idmedicamento;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "ACTIVO")
	private char activo;
	
	@Column(name = "TIPO")
	private String tipo;

	public Integer getIdmedicamento() {
		return idmedicamento;
	}

	public void setIdmedicamento(Integer idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
