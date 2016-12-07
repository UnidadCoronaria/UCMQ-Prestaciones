package com.unidadcoronaria.prestaciones.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Provider;
import com.unidadcoronaria.prestaciones.repository.ResourceProviderRepository;

@Component("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {
	
    final static Logger logger = Logger.getLogger(ProviderServiceImpl.class);
	
	@Autowired
    private ResourceProviderRepository resourceProviderRepository;

	@Override
	public Provider getProvider(Integer providerId) {
		
		Provider provider = new Provider();
		provider.setName(this.resourceProviderRepository.getProviderName(providerId));
		provider.setProviderId(providerId);
		
		return provider;
	}

}
