package com.unidadcoronaria.prestaciones.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Device;
import com.unidadcoronaria.prestaciones.domain.DeviceMessage;
import com.unidadcoronaria.prestaciones.domain.Guard;
import com.unidadcoronaria.prestaciones.domain.dto.DeviceMessageDTO;
import com.unidadcoronaria.prestaciones.exception.MedicalServiceNotFoundException;
import com.unidadcoronaria.prestaciones.repository.DeviceMessageRepository;

@Component("deviceMessageService")
@Transactional
public class DeviceMessageServiceImpl implements DeviceMessageService {
	
	final static Logger logger = Logger.getLogger(DeviceMessageServiceImpl.class);
	
	@Autowired
	public DeviceMessageRepository deviceMessageRepository;

	
	public DeviceMessage getDeviceMessage(Integer deviceMessageId) {
		
		return deviceMessageRepository.findByDeviceMessageId(deviceMessageId);
	}

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

	public DeviceMessage saveDeviceMessage(Integer deviceId, DeviceMessageDTO deviceMessageDTO) {
		
		try {
			DeviceMessage deviceMessage = new DeviceMessage();
			Device device = new Device();
			Guard guard = new Guard();
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			
			device.setDeviceId(deviceId);
			
			guard.setGuardId(deviceMessageDTO.getGuardId());
			
			deviceMessage.setDateTime(dateFormatter.parse(dateFormatter.format(date)));
			deviceMessage.setMessage(deviceMessageDTO.getMessage());
			deviceMessage.setDevice(device);
			deviceMessage.setGuard(guard);
			deviceMessage.setSendCallcenter('F');
			
			return deviceMessageRepository.save(deviceMessage);
			
		} catch (Exception e) {
			throw new MedicalServiceNotFoundException("Error saving DeviceMessage into DB");
		}
		
	}
	
}
