package com.csmtech.service;

import java.util.List;

public interface PatientService {

	List getPatientDetailes(String mbn);

	
	List getPatientHistoryByPid(String pid);

}
