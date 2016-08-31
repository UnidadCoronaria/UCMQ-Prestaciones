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

}
