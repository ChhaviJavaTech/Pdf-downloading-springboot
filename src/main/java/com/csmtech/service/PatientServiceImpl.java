package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.dao.PatientRepository;
import com.csmtech.dao.PrescriptioRep;



@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PrescriptioRep prep;
	
	@Override
	public List getPatientDetailes(String mbn) {
		List res= patientRepository.getPatientDetailes(mbn);
		return res;
	}

	
	@Override
	public List getPatientHistoryByPid(String pid) {
		List res= patientRepository.getPatientDetailesHistory(pid);
		//List res=prep.findAllByPatientId(pid);
		return res;
	}

}
