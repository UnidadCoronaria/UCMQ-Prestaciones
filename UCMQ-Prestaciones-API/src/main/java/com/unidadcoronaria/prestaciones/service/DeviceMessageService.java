package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.DeviceMessage;
import com.unidadcoronaria.prestaciones.domain.dto.DeviceMessageDTO;

public interface DeviceMessageService {
	
	DeviceMessage getDeviceMessage(Integer deviceMessageId);
	
	public List<DeviceMessage> getDeviceMessageList(Integer guardId, Integer deviceId);
	
	public void saveDeviceMessage(Integer deviceId, DeviceMessageDTO deviceMessageDTO );

}
