package com.unidadcoronaria.prestaciones.domain.dto;

import java.util.List;

public class CloseMedicalServiceResourceDTO {
	
	private List<MedicalServiceMedicamentDTO> listMedicalServiceMedicamentDTO;
	private List<Integer> listDiagnosticId;
	private MedicalServiceResourceDTO medicalServiceResourceDTO;
	
	public List<MedicalServiceMedicamentDTO> getListMedicalServiceMedicamentDTO() {
		return listMedicalServiceMedicamentDTO;
	}
	public void setListMedicalServiceMedicamentDTO(
			List<MedicalServiceMedicamentDTO> listMedicalServiceMedicamentDTO) {
		this.listMedicalServiceMedicamentDTO = listMedicalServiceMedicamentDTO;
	}
	public List<Integer> getListDiagnosticId() {
		return listDiagnosticId;
	}
	public void setListDiagnosticId(List<Integer> listDiagnosticId) {
		this.listDiagnosticId = listDiagnosticId;
	}
	public MedicalServiceResourceDTO getMedicalServiceResourceDTO() {
		return medicalServiceResourceDTO;
	}
	public void setMedicalServiceResourceDTO(
			MedicalServiceResourceDTO medicalServiceResourceDTO) {
		this.medicalServiceResourceDTO = medicalServiceResourceDTO;
	}
	                          

}
