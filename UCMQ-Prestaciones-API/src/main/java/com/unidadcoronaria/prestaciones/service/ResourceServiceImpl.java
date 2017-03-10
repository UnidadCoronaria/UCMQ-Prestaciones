package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.repository.ResourceRepository;

@Component("resourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService  {

	final static Logger logger = Logger.getLogger(ResourceServiceImpl.class);
	
	@Autowired
    private ResourceRepository resourceRepository;
	
	public Resource getResourceById(Integer resourceId) {
		return resourceRepository.findByResourceId(resourceId) ;
	}
	
	@Override
	public Resource getResourceByImei(String imei) {
		// TODO Auto-generated method stub
		return resourceRepository.findResourceByImei(imei);
	}
	
	public void updateResource(String imei, String tokenGcm) {
		Resource resource = getResourceByImei(imei);
		resource.setTokenGcm(tokenGcm);
		resourceRepository.save(resource);
	}
	

}
