package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unidadcoronaria.prestaciones.domain.Medicament;

public interface MedicamentRepository extends CrudRepository<Medicament, Long> {
	
	@Query("SELECT m FROM Medicament m WHERE m.active = 'T'")
	public List<Medicament> getActivesMedicaments();

}
