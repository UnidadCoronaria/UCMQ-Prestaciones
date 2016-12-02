package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unidadcoronaria.prestaciones.domain.ResourceProvider;

public interface ResourceProviderRepository extends CrudRepository<ResourceProvider, Long> {
	
	@Query("SELECT rp FROM ResourceProvider rp WHERE rp.resource.resourceId = :resourceId")
	public List<ResourceProvider> findProviderByResourceId(@Param("resourceId") Integer resourceId);

}
