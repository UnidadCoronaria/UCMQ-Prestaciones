package com.unidadcoronaria.prestaciones.job;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import com.unidadcoronaria.prestaciones.domain.DeviceMessage;
import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;
import com.unidadcoronaria.prestaciones.domain.Notification;
import com.unidadcoronaria.prestaciones.domain.Resource;
import com.unidadcoronaria.prestaciones.service.DeviceMessageService;
import com.unidadcoronaria.prestaciones.service.MedicalServiceResourceService;
import com.unidadcoronaria.prestaciones.service.NotificationService;
import com.unidadcoronaria.prestaciones.service.ResourceService;

@Component
public class NotificationJob {
	
	final static Logger logger = Logger.getLogger(NotificationJob.class);
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	ResourceService resourceService;
	
	@Autowired
	DeviceMessageService deviceMessageService;
	
	@Autowired
	private MedicalServiceResourceService medicalServiceResourceService;

	@Scheduled(fixedRate = 20000)
	public void reportCurrentTime() {
		List<Notification> notificationList; 
		notificationList = notificationService.getNotificationList();
		
		if (notificationList != null) {

			//MedicalServiceResource medicalServiceResource; 
			for(int i=0;i<notificationList.size();i++){
				
				Resource resource = null;
				
				if (notificationList.get(i).getTypeOfNotification().equals("MSJ")) {
					DeviceMessage deviceMessage = deviceMessageService.getDeviceMessage(notificationList.get(i).getId());
					resource = resourceService.getResourceByImei(deviceMessage.getDevice().getImei());
				}
				
				if (notificationList.get(i).getTypeOfNotification().equals("PRN")) {
					MedicalServiceResource medicalServiceResource;
					medicalServiceResource = medicalServiceResourceService.getMedicalServiceResource(notificationList.get(i).getId());
					logger.info("Notification sent MedicalServiceResourceID: " + medicalServiceResource.getMedicalServiceResourceId());
					resource = resourceService.getResourceById(medicalServiceResource.getResource().getResourceId());
				}
				logger.info("Notification sent Resource: " + resource.getResourceId());
			    //medicalServiceResource = medicalServiceResourceService.getMedicalServiceResource(notificationList.get(i).getId());
				//Resource resource = resourceService.getResourceById(medicalServiceResource.getResource().getResourceId());
					
				AsyncRestTemplate asycTemp = new AsyncRestTemplate();
					
				String url ="https://fcm.googleapis.com/fcm/send";
				HttpMethod method = HttpMethod.POST;
				HttpHeaders headers = new HttpHeaders();
					
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.set("Authorization", "key=AAAAu5ODMFk:APA91bF9dbcmYSP0lYrKBbvAl-30WvOs3hFPfBS7vrdm8edM0x_rCgL7HGPG-Nzff7RHRqJgGP1C3GRFmnpwZ9PGNN952KOzCx3pe5EMLY__2qPue3LCtvw4Of13uCJFadFOkXIXG5rb");
				                                              
				try {
					JSONArray datasets = new JSONArray();
					JSONObject data = new JSONObject();
					data.put("id", notificationList.get(i).getId());
					data.put("type", notificationList.get(i).getTypeOfNotification());
					datasets.put(data);
						
					JSONObject tokenGCM = new JSONObject();
					tokenGCM.put("to", resource.getTokenGcm());	
					tokenGCM.put("data", data);
					
					HttpEntity<String> entity = new HttpEntity<String>(tokenGCM.toString() ,headers);
					ListenableFuture<ResponseEntity<String>> resFuture = asycTemp.exchange(url, method, entity, String.class);
					
					ResponseEntity<String> responseEntity = resFuture.get();
					if (responseEntity.getStatusCode() == HttpStatus.OK ) {
						logger.info("Notification sent ID: " + notificationList.get(i).getNotificationId());
					    notificationService.deleteNotification(notificationList.get(i).getNotificationId());
					}
					
				} catch (JSONException e) {
					e.printStackTrace();
			    } catch (InterruptedException e) {
				    e.printStackTrace();
			    } catch (ExecutionException e) {
				    e.printStackTrace();
			    }
				
				
				
				/*
				try {
					ResponseEntity<String> responseEntity = resFuture.get();
					if (responseEntity.getStatusCode() == HttpStatus.OK ) {
						logger.info("Notification sent ID: " + notificationList.get(i).getNotificationId());
					    notificationService.deleteNotification(notificationList.get(i).getNotificationId());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}*/
			}	
		}	
		
	}

}
