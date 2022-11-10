package com.acmefresh.service;

import java.util.List;

import com.acmefresh.entites.Sellers;
import com.masai.exceptions.SellersException;

public interface SellersService {
	public Sellers addNewSellers(Sellers Sellers,String key)throws SellersException;
	
	public Sellers deleteSellersById(Integer SellersId,String key)throws SellersException;
	
	public Sellers updateSellers(Sellers Sellers,String key)throws SellersException;
	
	public Sellers getSellerstById(Integer SellersId,String key)throws SellersException;
		
	public List<Sellers> getAllSellerss(String key)throws SellersException;
	
}
