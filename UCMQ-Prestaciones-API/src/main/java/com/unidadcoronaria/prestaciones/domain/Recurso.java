package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	

}
