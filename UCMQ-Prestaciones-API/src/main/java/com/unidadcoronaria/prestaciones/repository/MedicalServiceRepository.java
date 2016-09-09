package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unidadcoronaria.prestaciones.domain.MedicalService;

public interface MedicalServiceRepository extends CrudRepository<MedicalService, Long> {

    //MedicalService findByMedicalServiceId(Integer id);
    
    public List<MedicalService> findByMedicalServiceId(Integer id);
    
    
}