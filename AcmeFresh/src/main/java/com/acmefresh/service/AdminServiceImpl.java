package com.acmefresh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.dao.AdminDao;
import com.acmefresh.dao.CurrentAdminSessionDao;
import com.acmefresh.entites.Admin;
import com.acmefresh.entites.CurrentAdminSession;
import com.masai.exceptions.AdminException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private CurrentAdminSessionDao sDao;

	@Override
	public Admin createCustomer(Admin admin) throws AdminException {
		Admin existingAdmin= aDao.findByMobile(admin.getMobile());
		
		if(existingAdmin != null) 
			throw new AdminException("Admin Already Registered with given UserName");
			return aDao.save(admin);
			
	}

	@Override
	public Admin updateCustomer(Admin admin, String key) throws AdminException {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to update a Admin");
		}
		
		if(admin.getAdminId() == loggedInAdmin.getUserId()) {
			return aDao.save(admin);
		}
		else
			throw new AdminException("Invalid Admin Details, please login first");
	}
		
		
		
}


