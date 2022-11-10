package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.entites.Sellers;

@Repository
public interface SellersDao extends JpaRepository<Sellers, Integer> {

}
