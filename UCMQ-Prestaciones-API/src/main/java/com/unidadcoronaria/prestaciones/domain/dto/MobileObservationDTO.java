package com.unidadcoronaria.prestaciones.domain.dto;

public class MobileObservationDTO {
	
	private Integer resourceId;
	private Integer typeMobileObservationId;
	private Integer guardId;
	private String observation;
	
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getTypeMobileObservationId() {
		return typeMobileObservationId;
	}
	public void setTypeMobileObservationId(Integer typeMobileObservationId) {
		this.typeMobileObservationId = typeMobileObservationId;
	}
	public Integer getGuardId() {
		return guardId;
	}
	public void setGuardId(Integer guardId) {
		this.guardId = guardId;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	 
}

