package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.ResourceProvider;
import com.unidadcoronaria.prestaciones.repository.ResourceProviderRepository;

@Component("resourceProvider")
@Transactional
public class ResourceProviderServiceImpl implements ResourceProviderService {
	
	final static Logger logger = Logger.getLogger(ResourceProviderServiceImpl.class);
	
	@Autowired
	ResourceProviderRepository resourceProviderRepository;

	@Override
	public List<ResourceProvider> getResourceProviderId(Integer resourceId) {

		return resourceProviderRepository.findProviderByResourceId(resourceId);
	}

}
