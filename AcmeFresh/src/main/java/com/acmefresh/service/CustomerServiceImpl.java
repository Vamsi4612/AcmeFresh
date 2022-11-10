package com.acmefresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.dao.AutomationTechniquesDao;
import com.acmefresh.dao.CurrentAdminSessionDao;
import com.acmefresh.dao.CustomersDao;
import com.acmefresh.dao.PlantsDao;
import com.acmefresh.entites.AutomationTechniques;
import com.acmefresh.entites.CurrentAdminSession;
import com.acmefresh.entites.Customers;
import com.acmefresh.entites.Plants;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.CustomersException;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomersDao customerDao;
	
	@Autowired
	private PlantsDao plantsDao;
	
	@Autowired
	private AutomationTechniquesDao techniquesDao;
	
	@Autowired
	private CurrentAdminSessionDao sessionDao;
	
	@Override
	public Customers addNewCustomers(Customers customers,String key) throws CustomersException {
		
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			if(customers!=null) {
				
				List<AutomationTechniques> at = customers.getTechniquesChoosen();
				
				for(AutomationTechniques el : at) {
					el.setCustomer(customers);
				}
				
				List<Plants> p = customers.getPlantsChoosen();
				
				for(Plants el : p) {
					el.setCustomer(customers);
				}
				
				Customers c = customerDao.save(customers);
				
				return c;
			}
			else {
				throw new CustomersException("Input Customers details are not valid");
			}
		}
		
		
	}

	@Override
	public Customers getCustomerstById(Integer CustomersId,String key) throws CustomersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Optional<Customers> opt = customerDao.findById(CustomersId);
			if(opt.isPresent()) {
				return opt.get();
			}
			else {
				throw new CustomersException("No Customers present with id : "+CustomersId);
			}
		}
	}

	@Override
	public List<Customers> getAllCustomerss(String key) throws CustomersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			List<Customers> list = customerDao.findAll();
			if(list.size()>0) {
				return list;
			}
			else {
				throw new CustomersException("Customers list is zero");
			}
		}
		
	}

	@Override
	public Customers deleteCustomersById(Integer CustomersId,String key) throws CustomersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Optional<Customers> opt = customerDao.findById(CustomersId);
			if(opt.isPresent()) {
				Customers e = opt.get();
				customerDao.delete(e);
				return e;
			}
			else {
				throw new CustomersException("No Customers present with id : "+CustomersId);
			}
		}
	}

	@Override
	public Customers updateCustomers(Customers customers,String key) throws CustomersException {
		CurrentAdminSession loggedInAdmin= sessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Optional<Customers> opt = customerDao.findById(customers.getId());
			if(opt.isPresent()) {
				Customers e = opt.get();
				List<AutomationTechniques> at = customers.getTechniquesChoosen();
				
				for(AutomationTechniques el : at) {
					el.setCustomer(customers);
				}
				
				List<Plants> p = customers.getPlantsChoosen();
				
				for(Plants el : p) {
					el.setCustomer(customers);
				}
				customerDao.save(customers);
				return e; 
			}
			else {
				throw new CustomersException("No Customers present with given details");
			}
		}
	}
	

}
