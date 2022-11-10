package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.entites.CurrentAdminSession;

public interface CurrentAdminSessionDao extends JpaRepository<CurrentAdminSession, Integer> {
	public  CurrentAdminSession  findByUuid(String uuid);
}
