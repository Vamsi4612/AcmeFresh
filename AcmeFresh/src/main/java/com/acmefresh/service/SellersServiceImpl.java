package com.acmefresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.dao.CurrentAdminSessionDao;
import com.acmefresh.dao.SellersDao;
import com.acmefresh.entites.CurrentAdminSession;
import com.acmefresh.entites.ProducedGoodsToSell;
import com.acmefresh.entites.Sellers;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.SellersException;

@Service
public class SellersServiceImpl implements SellersService{
	@Autowired
	private SellersDao sellersDao;
	
	@Autowired
	private CurrentAdminSessionDao sessionDao;

	@Override
	public Sellers addNewSellers(Sellers sellers,String key) throws SellersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			if(sellers!=null) {
				List<ProducedGoodsToSell> at = sellers.getGoodsToSell();
				
				for(ProducedGoodsToSell el : at) {
					el.setSeller(sellers);
				}
				
				Sellers e = sellersDao.save(sellers);
				return e;
			}
			else {
				throw new SellersException("given Sellers details are not valid");
			}
		}
	}
	

	@Override
	public Sellers deleteSellersById(Integer sellersId,String key) throws SellersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Optional<Sellers> opt = sellersDao.findById(sellersId);
			if(opt.isPresent()) {
				Sellers e = opt.get();
				sellersDao.delete(e);
				return e;
			}
			else {
				throw new SellersException("No Sellers present with id : "+sellersId);
			}
		}
	}

	@Override
	public Sellers updateSellers(Sellers sellers,String key) throws SellersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Optional<Sellers> opt = sellersDao.findById(sellers.getId());
			if(opt.isPresent()) {
				List<ProducedGoodsToSell> at = sellers.getGoodsToSell();
				
				for(ProducedGoodsToSell el : at) {
					el.setSeller(sellers);
				}
				Sellers e = opt.get();
				sellersDao.save(sellers);
				return e; 
			}
			else {
				throw new SellersException("No Sellers present with given details");
			}
		}
	}
	
	@Override
	public Sellers getSellerstById(Integer sellersId,String key) throws SellersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Optional<Sellers> opt = sellersDao.findById(sellersId);
			if(opt.isPresent()) {
				return opt.get();
			}
			else {
				throw new SellersException("No Sellers present with id : "+sellersId);
			}
		}
	}

	@Override
	public List<Sellers> getAllSellerss(String key) throws SellersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			List<Sellers> list = sellersDao.findAll();
			if(list.size()>0) {
				return list;
			}
			else {
				throw new SellersException("Sellers list is zero");
			}
		}
		
	}
}
