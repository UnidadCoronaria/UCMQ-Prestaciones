package com.unidadcoronaria.prestaciones.service;

import com.unidadcoronaria.prestaciones.domain.Resource;

public interface ResourceService {
	
	public Resource getResourceByImei(String imei);

}
