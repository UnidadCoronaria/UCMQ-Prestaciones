package com.unidadcoronaria.prestaciones.repository;

import org.springframework.data.repository.CrudRepository;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceDiagnostic;

public interface MedicalServiceDiagnosticRepository extends CrudRepository<MedicalServiceDiagnostic,Long> {
	

}
