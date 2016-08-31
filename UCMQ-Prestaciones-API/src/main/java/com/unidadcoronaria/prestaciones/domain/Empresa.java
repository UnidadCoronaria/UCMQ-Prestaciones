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
public class Empresa {
	
	@Id
	@Column(name = "IDEMPRESA")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_EMPRESA")
	private Integer idempresa;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "NOMBREDEFANTASIA")
	private String nombredefantasia;

	public Integer getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombredefantasia() {
		return nombredefantasia;
	}

	public void setNombredefantasia(String nombredefantasia) {
		this.nombredefantasia = nombredefantasia;
	}

}
