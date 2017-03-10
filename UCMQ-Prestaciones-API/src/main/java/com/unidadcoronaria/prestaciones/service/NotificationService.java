package com.unidadcoronaria.prestaciones.service;

import java.util.List;

import com.unidadcoronaria.prestaciones.domain.Notification;

public interface NotificationService {
	
	public List<Notification> getNotificationList();
	
	public void deleteNotification(Integer notificationId);
	       

}
