package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.entites.Plants;

@Repository
public interface PlantsDao extends JpaRepository<Plants, Integer> {
	
}
