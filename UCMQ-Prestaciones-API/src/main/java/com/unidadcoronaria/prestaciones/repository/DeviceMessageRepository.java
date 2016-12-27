package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unidadcoronaria.prestaciones.domain.DeviceMessage;

public interface DeviceMessageRepository extends CrudRepository<DeviceMessage, Long> {
	
	public DeviceMessage findByDeviceMessageId(Integer deviceMessageId);
	
    @Query(value = "Select * From Guardias_PDC_GetMensajesPager(:guardId,:deviceId)", nativeQuery = true) 
    public List<Integer> getDeviceMessagesList(@Param("guardId") Integer guardId, @Param("deviceId") Integer deviceId);
	
}
