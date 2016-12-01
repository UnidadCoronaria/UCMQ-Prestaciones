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
@SequenceGenerator(name = "INC_MOVILOBSERVACION", sequenceName = "IDMOVILOBSERVACION")
@Table(name="MOVILESOBSERVACIONES")
public class MobileObservation {
	
	@Id
	@Column(name = "IDMOVILOBSERVACION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MOVILOBSERVACION")
	private Integer mobileObservationId;
	
	@ManyToOne
	@JoinColumn(name = "IDTIPOOBSERVACIONMOVIL")
	private TypeMobileObservation typeMobileObservation;

	public Integer getMobileObservationId() {
		return mobileObservationId;
	}

	public void setMobileObservationId(Integer mobileObservationId) {
		this.mobileObservationId = mobileObservationId;
	}

	public TypeMobileObservation getTypeMobileObservation() {
		return typeMobileObservation;
	}

	public void setTypeMobileObservation(TypeMobileObservation typeMobileObservation) {
		this.typeMobileObservation = typeMobileObservation;
	}

}
