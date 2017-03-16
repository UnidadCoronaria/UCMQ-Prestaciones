package com.unidadcoronaria.prestaciones.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@SequenceGenerator(name = "INC_PRESTACION", sequenceName = "IDPRESTACION")
@Table(name="PRESTACIONES")
public class MedicalService {
	

	@Id
	@Column(name = "IDPRESTACION")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "INC_PRESTACION")
	private Integer medicalServiceId;
	
	@Column(name = "NUMERODEPRESTACION")
	private Integer number;
	
	@Column(name = "FECHA")
	private Date date;
	
	@Column(name = "TELEFONO")
	private String telephone;
	
	@ManyToOne
	@JoinColumn(name = "IDDOMICILIOPRESTACION")
	private AddressMedicalService addressMedicalService;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "SEXO")
	private String sex;
	
	@Column(name = "EDAD")
	private Integer age;
	
	@Column(name = "COPAGO")
	private char copayment;
	
	@Column(name = "COPAGOPAGADO")
	private char copaymentPaid;
	
	@Column(name = "ESTADO")
	private String status;
	
	@Column(name = "IDCABINA")
	private Integer cabinId;
	
	@Column(name = "COLOR")
	private String colour;
	
	@Column(name = "PROTOCOLOINTERNACION")
	private char internmentProtocol;
	
	@Column(name = "PROTOCOLOECG")
	private char ecgProtocol;  
	
	@Column(name = "ECG")
	private char ecg;
	
	@Column(name = "COPAGOIMPORTE")
	private Double copaymentAmount;
	
	public Integer getMedicalServiceId() {
		return medicalServiceId;
	}

	public void setMedicalServiceId(Integer medicalServiceId) {
		this.medicalServiceId = medicalServiceId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AddressMedicalService getAddressMedicalService() {
		return addressMedicalService;
	}

	public void setAddressMedicalService(AddressMedicalService addressMedicalService) {
		this.addressMedicalService = addressMedicalService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public char getCopayment() {
		return copayment;
	}

	public void setCopayment(char copayment) {
		this.copayment = copayment;
	}

	public char getCopaymentPaid() {
		return copaymentPaid;
	}

	public void setCopaymentPaid(char copaymentPaid) {
		this.copaymentPaid = copaymentPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getCabinId() {
		return cabinId;
	}

	public void setCabinId(Integer cabinId) {
		this.cabinId = cabinId;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public char getInternmentProtocol() {
		return internmentProtocol;
	}

	public void setInternmentProtocol(char internmentProtocol) {
		this.internmentProtocol = internmentProtocol;
	}

	public char getEcgProtocol() {
		return ecgProtocol;
	}

	public void setEcgProtocol(char ecgProtocol) {
		this.ecgProtocol = ecgProtocol;
	}

	public char getEcg() {
		return ecg;
	}

	public void setEcg(char ecg) {
		this.ecg = ecg;
	}

	public Double getCopaymentAmount() {
		return copaymentAmount;
	}

	public void setCopaymentAmount(Double copaymentAmount) {
		this.copaymentAmount = copaymentAmount;
	}

	public MedicalService() {
		super();
	}

	public MedicalService(Integer medicalServiceId) {
		super();
		this.medicalServiceId = medicalServiceId;
	}
	
	
}

