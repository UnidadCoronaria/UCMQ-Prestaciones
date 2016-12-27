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
@SequenceGenerator(name = "INC_MENSAJEPAGER", sequenceName = "IDMENSAJEPAGER")
@Table(name="MENSAJESPAGERS")
public class DeviceMessage {
	
	@Id
	@Column(name = "IDMENSAJEPAGER")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_MENSAJEPAGER")
	private Integer deviceMessageId;
	
	@Column(name = "FECHA")
	private Date dateTime;
	
	@Column(name = "MENSAJE")
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "IDPAGER")
	private Device device;
	
	@ManyToOne
	@JoinColumn(name = "IDGUARDIA")
	private Guard guard;
	
	@Column(name = "ENVIADESPACHO")
	private char sendCallcenter;

	public Integer getDeviceMessageId() {
		return deviceMessageId;
	}

	public void setDeviceMessageId(Integer deviceMessageId) {
		this.deviceMessageId = deviceMessageId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Guard getGuard() {
		return guard;
	}

	public void setGuard(Guard guard) {
		this.guard = guard;
	}

	public char getSendCallcenter() {
		return sendCallcenter;
	}

	public void setSendCallcenter(char sendCallcenter) {
		this.sendCallcenter = sendCallcenter;
	}
	
}
