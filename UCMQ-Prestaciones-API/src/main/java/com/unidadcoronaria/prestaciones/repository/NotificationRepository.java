package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.unidadcoronaria.prestaciones.domain.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {
	
	@Query("SELECT n FROM Notification n")
	public List<Notification> getNotificationList();

}
