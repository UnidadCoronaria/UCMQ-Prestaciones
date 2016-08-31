package com.unidadcoronaria.prestaciones.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


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
	
	
	
	
}
