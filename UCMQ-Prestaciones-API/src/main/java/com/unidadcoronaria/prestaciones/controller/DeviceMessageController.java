package com.unidadcoronaria.prestaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unidadcoronaria.prestaciones.constant.Constants;
import com.unidadcoronaria.prestaciones.domain.DeviceMessage;
import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.domain.dto.DeviceMessageDTO;
import com.unidadcoronaria.prestaciones.service.AuthorizationService;
import com.unidadcoronaria.prestaciones.service.DeviceMessageService;
import com.unidadcoronaria.prestaciones.service.ResourceService;

@Controller
@EnableAutoConfiguration
public class DeviceMessageController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private DeviceMessageService deviceMessageService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value = "/deviceMessage/{guardId}/messages",  method = RequestMethod.GET)
	@ResponseBody
	List<DeviceMessage> listMedicalServiceResourcePending(@PathVariable("guardId") Integer guardId, @RequestHeader(value = Constants.AUTHORIZATION_HEADER) final String token) {
		this.authorizationService.validateToken(token);
		Resource resource = resourceService.getResourceByImei(token);
		return this.deviceMessageService.getDeviceMessageList(guardId, resource.getDevice().getDeviceId());
	}
	
	@RequestMapping(value = "/deviceMessage/send",  method = RequestMethod.POST)
	@ResponseBody
	public DeviceMessage sendDeviceMessage(@RequestBody DeviceMessageDTO deviceMessageDTO, @RequestHeader(value = Constants.AUTHORIZATION_HEADER ) final String token) {
		this.authorizationService.validateToken(token);
		Resource resource = resourceService.getResourceByImei(token);
		return deviceMessageService.saveDeviceMessage(resource.getDevice().getDeviceId(), deviceMessageDTO);
	}
}
