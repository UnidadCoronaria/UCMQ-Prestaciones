package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.DeviceMessage;

public interface DeviceMessageService {
	
	DeviceMessage getDeviceMessage(Integer deviceMessageId);
	
	public List<DeviceMessage> getDeviceMessageList(Integer guardId, Integer deviceId);

}
