package com.acmefresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.entites.ProducedGoodsToSell;

@Repository
public interface ProducedGoodsToSellDao extends JpaRepository<ProducedGoodsToSell, Integer> {

}
