package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@SequenceGenerator(name = "INC_NOTIFICACIONPDC", sequenceName = "IDNOTIFICACIONPDC")
@Table(name="NOTIFICACIONESPDC")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {
	
	@Id
	@Column(name = "IDNOTIFICACIONPDC")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_NOTIFICACIONPDC")
	private Integer notificationId;
	
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "TIPODENOTIFICACION")
	private String typeOfNotification;

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeOfNotification() {
		return typeOfNotification;
	}

	public void setTypeOfNotification(String typeOfNotification) {
		this.typeOfNotification = typeOfNotification;
	}
	
	@Override
	public String toString() {
	return "Value{" +
	              "id=" + id +
	              ", typeOfNotification='" + typeOfNotification + '\'' +
	              '}';
	    }

}
