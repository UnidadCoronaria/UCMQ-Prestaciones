package com.unidadcoronaria.prestaciones.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.unidadcoronaria.prestaciones.domain.DomicilioPrestacion;


@Entity
@SequenceGenerator(name = "INC_PRESTACION", sequenceName = "IDPRESTACION")
@Table(name="PRESTACIONES")
public class Prestacion {
	
	@Id
	@Column(name = "IDPRESTACION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PRESTACION")
	private Integer idprestacion;
	
	@Column(name = "NUMERODEPRESTACION")
	private Integer numerodeprestacion;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "IDDOMICILIOPRESTACION")
	private DomicilioPrestacion domicilioprestacion;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "EDAD")
	private Integer edad;
	
	@Column(name = "COPAGO")
	private char copago;
	
	@Column(name = "COPAGOPAGADO")
	private char copagopagado;
	
	@Column(name = "ESTADO")
	private String estado;
	
	public Integer getIdprestacion() {
		return idprestacion;
	}

	public void setIdprestacion(Integer idprestacion) {
		this.idprestacion = idprestacion;
	}

	public Integer getNumerodeprestacion() {
		return numerodeprestacion;
	}

	public void setNumerodeprestacion(Integer numerodeprestacion) {
		this.numerodeprestacion = numerodeprestacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public DomicilioPrestacion getDomicilioprestacion() {
		return domicilioprestacion;
	}

	public void setDomicilioprestacion(DomicilioPrestacion domicilioprestacion) {
		this.domicilioprestacion = domicilioprestacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public char getCopago() {
		return copago;
	}

	public void setCopago(char copago) {
		this.copago = copago;
	}

	public char getCopagopagado() {
		return copagopagado;
	}

	public void setCopagopagado(char copagopagado) {
		this.copagopagado = copagopagado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	
	
	
}
