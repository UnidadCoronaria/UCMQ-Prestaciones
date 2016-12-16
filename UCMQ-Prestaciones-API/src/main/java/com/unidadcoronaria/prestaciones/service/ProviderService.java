package com.unidadcoronaria.prestaciones.service;


import java.util.List;

import com.unidadcoronaria.prestaciones.domain.Provider;
import com.unidadcoronaria.prestaciones.domain.ResourceProvider;

public interface ProviderService {
	
	public Provider getProvider(Integer providerId);
	
	public List<Provider> listProvider(List<ResourceProvider> resourceProviderList);

}
