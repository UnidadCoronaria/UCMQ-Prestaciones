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

@Entity
@SequenceGenerator(name = "INC_MOVILOBSERVACION", sequenceName = "IDMOVILOBSERVACION")
@Table(name="MOVILESOBSERVACIONES")
public class MobileObservation {
	
	@Id
	@Column(name = "IDMOVILOBSERVACION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MOVILOBSERVACION")
	private Integer mobileObservationId;
	
	@ManyToOne
	@JoinColumn(name = "IDMOVIL")
	private Mobile mobile;
	
	@ManyToOne
	@JoinColumn(name = "IDTIPOOBSERVACIONMOVIL")
	private TypeMobileObservation typeMobileObservation;
	
	@ManyToOne
	@JoinColumn(name = "IDGUARDIA")
	private Guard guard;
	
	@Column(name = "OBSERVACIONES")
	private String observation;
	
	@Column(name = "FECHAHORA")
	private Date dateTime;
	
	@Column(name = "FECHA")
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name = "HORA")
	private String time;

	public Integer getMobileObservationId() {
		return mobileObservationId;
	}

	public void setMobileObservationId(Integer mobileObservationId) {
		this.mobileObservationId = mobileObservationId;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public TypeMobileObservation getTypeMobileObservation() {
		return typeMobileObservation;
	}

	public void setTypeMobileObservation(TypeMobileObservation typeMobileObservation) {
		this.typeMobileObservation = typeMobileObservation;
	}

	public Guard getGuard() {
		return guard;
	}

	public void setGuard(Guard guard) {
		this.guard = guard;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
