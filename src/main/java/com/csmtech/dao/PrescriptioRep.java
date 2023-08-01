package com.csmtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.model.Prescription_tbl;

@Repository
public interface PrescriptioRep extends JpaRepository<Prescription_tbl, Integer> {

	List<Prescription_tbl> findAllByPatientId(Integer pid);

}
