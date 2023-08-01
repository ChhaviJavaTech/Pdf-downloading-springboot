package com.csmtech.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.csmtech.dao.DiseaRepo;
import com.csmtech.dao.PrescriptioRep;
import com.csmtech.model.Disease_master;
import com.csmtech.model.Prescription_tbl;

@Controller
public class MyController {
	
	@Autowired
	private DiseaRepo drepo;
	
	@Autowired
	private PrescriptioRep preRe;
	
	@GetMapping("/")
	public String getForm(Model model) {
		
		model.addAttribute("disease",drepo.findAll());
		
		return "patientVisit";
	}
	
	@PostMapping("/save")
	public String Save(Prescription_tbl tbl,Model model) {
		tbl.setDate_of_visit(new Date());
		System.out.println(tbl);
		preRe.save(tbl);
		model.addAttribute("disease",drepo.findAll());
		return "patientVisit";
	}

}
