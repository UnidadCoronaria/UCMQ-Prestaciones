package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unidadcoronaria.prestaciones.domain.TypeMobileObservation;


public interface TypeMobileObservationRepository extends CrudRepository<TypeMobileObservation, Long> {
	
	@Query("SELECT t FROM TypeMobileObservation t")
	public List<TypeMobileObservation> getTypeMobileObservationList();
	
}
