package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.entites.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Admin findByMobile(String mobile);

}
