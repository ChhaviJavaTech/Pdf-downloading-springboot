package com.csmtech.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "patient_master")
public class Patient_Master {
	
	@Id
	private Integer patient_id;
	
	private String patient_name;
	
	private  Character gender ;
	
	private Date dob;
	
	private String phone_no;
	
	
	public String getDob() {
		
		SimpleDateFormat sd =new SimpleDateFormat("dd/MM/yyyy");
		
		return sd.format(this.dob);
	}

}
