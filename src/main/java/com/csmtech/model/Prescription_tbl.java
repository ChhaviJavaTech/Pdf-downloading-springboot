package com.csmtech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Prescription_tbl {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prescription_id;
	private String doctor_name;
	
	private Date date_of_visit;
	
	@Column(name = "patient_id")
	private Integer patientId;
	private Integer disease_id;
private String prescription_details;




}
