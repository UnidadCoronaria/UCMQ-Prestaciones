package com.unidadcoronaria.prestaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unidadcoronaria.prestaciones.domain.Diagnostic;

public interface DiagnosticRepository extends CrudRepository<Diagnostic, Long> {
	
	@Query("SELECT d FROM Diagnostic d WHERE d.active = 'T'")
	public List<Diagnostic> getActivesDiagnostic();

}

