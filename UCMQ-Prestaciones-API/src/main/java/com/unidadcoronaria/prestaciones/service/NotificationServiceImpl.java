package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unidadcoronaria.prestaciones.domain.Notification;
import com.unidadcoronaria.prestaciones.repository.NotificationRepository;

@Component("notificationService")
@Transactional
public class NotificationServiceImpl implements NotificationService {
	
	final static Logger logger = Logger.getLogger(NotificationServiceImpl.class);
	
	@Autowired
	public NotificationRepository notificationRepository;

	@Override
	public List<Notification> getNotificationList() {
		return notificationRepository.getNotificationList();
	}
	
	public void deleteNotification(Integer notificationId) {
		notificationRepository.delete(notificationId);
	}
	

}
