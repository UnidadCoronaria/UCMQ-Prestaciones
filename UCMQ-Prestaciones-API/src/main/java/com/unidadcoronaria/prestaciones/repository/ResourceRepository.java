package com.unidadcoronaria.prestaciones.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unidadcoronaria.prestaciones.domain.Resource;

public interface ResourceRepository extends CrudRepository<Resource, Long> {
	
	public Resource findByResourceId(Integer resourceId);
	
	@Query("SELECT r FROM Device d, Resource r WHERE r.device.deviceId = d.deviceId AND d.imei = :imei")
	public Resource findResourceByImei(@Param("imei") String imei);

}
