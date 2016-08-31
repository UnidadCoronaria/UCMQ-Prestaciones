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
public class TipoMovil {
	
	@Id
	@Column(name = "IDTIPOMOVIL")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_TIPOMOVIL")
	private Integer idtipomovil;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ALIAS")
	private String alias;

	public Integer getIdtipomovil() {
		return idtipomovil;
	}

	public void setIdtipomovil(Integer idtipomovil) {
		this.idtipomovil = idtipomovil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
