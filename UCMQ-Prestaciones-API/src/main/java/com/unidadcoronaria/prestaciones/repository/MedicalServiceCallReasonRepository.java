package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceCallReason;

public interface MedicalServiceCallReasonRepository extends CrudRepository<MedicalServiceCallReason, Long> {

	@Query("SELECT mscr FROM MedicalServiceCallReason mscr WHERE mscr.medicalService.medicalServiceId = :medicalServiceId")
	public List<MedicalServiceCallReason> getMedicalServiceCallReasonByMedicalServiceId(@Param("medicalServiceId") Integer medicalServiceId);
}
