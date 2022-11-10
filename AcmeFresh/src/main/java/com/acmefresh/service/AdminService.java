package com.acmefresh.service;

import com.acmefresh.entites.Admin;
import com.masai.exceptions.AdminException;

public interface AdminService {
	
	
	public Admin createCustomer(Admin admin)throws AdminException;
	
	public Admin updateCustomer(Admin admin,String key)throws AdminException;

}
