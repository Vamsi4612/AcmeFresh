package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.entites.CurrentCustomerSession;

public interface CurrentCustomerSessionDao extends JpaRepository<CurrentCustomerSession, Integer> {
	public  CurrentCustomerSession  findByUuid(String uuid);
}
