package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.entites.Customers;

@Repository
public interface CustomersDao extends JpaRepository<Customers, Integer> {
	public Customers findByMobile(String mobile);
}
