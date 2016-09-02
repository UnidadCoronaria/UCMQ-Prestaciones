package com.unidadcoronaria.prestaciones.repository;

import org.springframework.data.repository.CrudRepository;

import com.unidadcoronaria.prestaciones.domain.MedicalService;

public interface MedicalServiceRepository extends CrudRepository<MedicalService, Long> {

    MedicalService findById(Long id);
    
    
}