package com.unidadcoronaria.prestaciones.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.DeviceMessage;
import com.unidadcoronaria.prestaciones.exception.MedicalServiceNotFoundException;
import com.unidadcoronaria.prestaciones.repository.DeviceMessageRepository;

@Component("deviceMessageService")
@Transactional
public class DeviceMessageServiceImpl implements DeviceMessageService {
	
	final static Logger logger = Logger.getLogger(DeviceMessageServiceImpl.class);
	
	@Autowired
	public DeviceMessageRepository deviceMessageRepository;

	@Override
	public DeviceMessage getDeviceMessage(Integer deviceMessageId) {
		
		return deviceMessageRepository.findByDeviceMessageId(deviceMessageId);
	}

	@Override
	public List<DeviceMessage> getDeviceMessageList(Integer guardId, Integer deviceId) {
		
		try {
		    List<DeviceMessage> deviceMessageList = new ArrayList<DeviceMessage>();
		    List<Integer> deviceMessageIdList;
		    deviceMessageIdList = deviceMessageRepository.getDeviceMessagesList(guardId, deviceId);
		
		    for(int i=0;i<deviceMessageIdList.size();i++){	
			    DeviceMessage deviceMessage = new DeviceMessage();
			    deviceMessage = getDeviceMessage(deviceMessageIdList.get(i)); 
			    deviceMessageList.add(deviceMessage);	
		    }
		    return deviceMessageList;
		}catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error al consultar la DB");	
		}
		
	}
	
}
