package com.csmtech.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import com.csmtech.model.Patient_Master;

@Repository
public class PatientRepository {
	
	@PersistenceContext
	private EntityManager em;

	public List getPatientDetailes(String mbn) {
	List res=em.createStoredProcedureQuery("get_patient_detailes",Patient_Master.class).registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
		.setParameter(1, mbn).getResultList();
	
	
	
	System.out.println(res);
	if(res.isEmpty()) {
		return null;
	}
	else
		return res;
	}

	public List getPatientDetailesHistory(String pid) {
		Map<String, String> mp;
		List<Map<String, String>> lmap=new ArrayList<>();
		try {
		List<Object[]> resultList = em.createStoredProcedureQuery("pateDetl").registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
		.setParameter(1, pid).getResultList();
		for(Object[] obj:resultList) {
			
				mp=new HashMap<>();
				mp.put("prescription", obj[0].toString());
			mp.put("disease",obj[1].toString() );
			mp.put("name",obj[2].toString() );
			mp.put("gender",obj[3].toString() );
			mp.put("dob",obj[4].toString() );
			mp.put("dov",obj[5].toString() );
			lmap.add(mp);
		}}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		// TODO Auto-generated method stub
		return lmap;
	}
	
	

}
