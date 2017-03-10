package com.unidadcoronaria.prestaciones.service;

import com.unidadcoronaria.prestaciones.domain.Resource;

public interface ResourceService {
	
	public Resource getResourceById(Integer resourceId);
	
	public Resource getResourceByImei(String imei);
	
	public void updateResource(String imei, String tokenGcm);

}
