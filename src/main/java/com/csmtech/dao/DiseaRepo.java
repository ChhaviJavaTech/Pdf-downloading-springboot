package com.csmtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.model.Disease_master;

@Repository
public interface DiseaRepo extends JpaRepository<Disease_master, Integer> {

}
