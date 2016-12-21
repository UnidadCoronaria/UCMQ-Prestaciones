package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unidadcoronaria.prestaciones.domain.MedicalService;
import com.unidadcoronaria.prestaciones.domain.Resource;

public interface MedicalServiceRepository extends CrudRepository<MedicalService, Long> {

    
    public List<MedicalService> findByMedicalServiceId(Integer id);
    
	@Query(value = "Select R_IdPrestacion IdPrestacion, R_NumeroDePrestacion NumeroDePrestacion, R_Fecha Fecha, R_Telefono Telefono, R_IdDomicilioPrestacion IdDomicilioPrestacion, R_Nombre Nombre, R_Sexo Sexo, R_Edad Edad, R_Copago Copago, R_CopagoPagado CopagoPagado, R_Estado Estado, R_IdCabina IdCabina From APPANDROID(:P_ESTADO)", nativeQuery = true)
	public List<MedicalService> findByStatus(@Param("P_ESTADO") String estado);
	
	@Query("SELECT r FROM Device d, Resource r WHERE r.device.deviceId = d.deviceId AND d.imei = :imei")
	public Resource findResourceIdByImei(@Param("imei") String imei);
	
	@Query(value = "Select R_IdPrestacion IdPrestacion, R_NumeroDePrestacion NumeroDePrestacion, R_Fecha Fecha, R_Telefono Telefono, R_IdDomicilioPrestacion IdDomicilioPrestacion, R_Nombre Nombre, R_Sexo Sexo, R_Edad Edad, R_Copago Copago, R_CopagoPagado CopagoPagado, R_Estado Estado, R_IdCabina IdCabina, R_IdPrestacionRecurso medicalServiceResourceId From APP_GETPRESTPORRECURSO(:P_IDRECURSO)", nativeQuery = true)
	public List<MedicalService> findByResource(@Param("P_IDRECURSO") Integer resourceId);
	    
    
}