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
public class Movil {
	
	@Id
	@Column(name = "IDMOVIL")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MOVIL")
	private Integer idmovil;
	
	@ManyToOne
	@JoinColumn(name = "IDEMPRESA")
	private Empresa empresa;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ACTIVO")
	private char activo;
	
	@Column(name = "ALIAS")
	private String alias;
	
	@ManyToOne
	@JoinColumn(name = "IDTIPOMOVIL")
	private TipoMovil tipomovil;

	public Integer getIdmovil() {
		return idmovil;
	}

	public void setIdmovil(Integer idmovil) {
		this.idmovil = idmovil;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public TipoMovil getTipomovil() {
		return tipomovil;
	}

	public void setTipomovil(TipoMovil tipomovil) {
		this.tipomovil = tipomovil;
	}

}
