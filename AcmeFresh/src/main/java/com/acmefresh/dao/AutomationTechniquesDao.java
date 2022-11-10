package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.entites.AutomationTechniques;

@Repository
public interface AutomationTechniquesDao extends JpaRepository<AutomationTechniques, Integer> {

}
