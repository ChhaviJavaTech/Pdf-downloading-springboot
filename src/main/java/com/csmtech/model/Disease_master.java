package com.csmtech.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Disease_master {
	
	@Id
	private Integer disease_id;
	private String disease_name;

}
