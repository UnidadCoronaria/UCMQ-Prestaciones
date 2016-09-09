package com.unidadcoronaria.prestaciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "INC_PAGER", sequenceName = "IDPAGER")
@Table(name="PAGERS")
public class Device {
	
	@Id
	@Column(name = "IDPAGER")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PAGER")
	private Integer deviceId;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "TIPO")
	private String type;
	
	@Column(name = "IMEI")
	private String imei;

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	
	

}
