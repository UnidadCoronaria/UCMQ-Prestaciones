package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unidadcoronaria.prestaciones.domain.MedicalServiceResource;

public interface MedicalServiceResourceRepository extends CrudRepository<MedicalServiceResource,Long> {
	
	@Query("SELECT msr FROM MedicalServiceResource msr WHERE msr.resource.resourceId = :resourceId AND msr.canceled = 0 AND msr.closedMedicalService = 'F'")
	public List<MedicalServiceResource> findByResourceId(@Param("resourceId") Integer resourceId);
	
	public MedicalServiceResource findByMedicalServiceResourceId(Integer medicalServiceResourceId);
	
    @Query(value = "Select * From PrestRec_PDC_GetEstadoUbicacion(:medicalServiceResourceId)", nativeQuery = true) 
    public Integer getMedicalServiceResourceCurrentState(@Param("medicalServiceResourceId") Integer medicalServiceResourceId);
    
    @Query(value = "Select * From PrestRec_PDC_GetEventos(:medicalServiceResourceId)", nativeQuery = true) 
    public List<Integer> getMedicalServiceResourceAuthorizedStates(@Param("medicalServiceResourceId") Integer medicalServiceResourceId);
    
    @Query(value = "Select * From PrestRec_PDC_GetTraslado(:medicalServiceResourceId)", nativeQuery = true) 
    public Integer getMedicalServiceTransferId(@Param("medicalServiceResourceId") Integer medicalServiceResourceId);
    
	@Query(value = "Select * From PrestRec_PDC_SetEvento(:medicalServiceResourceId, :state, :latitude, :longitude)", nativeQuery = true)
	public char setMedicalServiceResourceState(
			@Param("medicalServiceResourceId") Integer medicalServiceResourceId,
			@Param("state") Integer state,
			@Param("latitude") Double latitude,
			@Param("longitude") Double longitude);
	
	@Query(value = "Select * From PrestTra_PDC_SetEvento(:medicalServiceTransferId, :state, :latitude, :longitude)", nativeQuery = true)
	public char setMedicalServiceTransferState(
			@Param("medicalServiceTransferId") Integer medicalServiceTransferId,
			@Param("state") Integer state,
			@Param("latitude") Double latitude,
			@Param("longitude") Double longitude);

    @Query(value = "Select * From Guardias_PDC_GetPrestRealizadas(:guardId)", nativeQuery = true) 
    public List<Integer> getAttendedMedicalServiceResource(@Param("guardId") Integer guardId);
    
    @Query("Select msr.medicalService.medicalServiceId From MedicalServiceResource msr WHERE msr.medicalServiceResourceId = :medicalServiceResourceId") 
    public Integer getMedicalServicesId(@Param("medicalServiceResourceId") Integer medicalServiceResourceId);
}
