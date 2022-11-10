package com.acmefresh.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.dao.AdminDao;
import com.acmefresh.dao.CurrentAdminSessionDao;
import com.acmefresh.dao.CurrentCustomerSessionDao;
import com.acmefresh.dao.CustomersDao;
import com.acmefresh.entites.Admin;
import com.acmefresh.entites.CurrentAdminSession;
import com.acmefresh.entites.CurrentCustomerSession;
import com.acmefresh.entites.Customers;
import com.acmefresh.entites.LoginDTO;
import com.masai.exceptions.LoginException;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomersDao cDao;
	
	@Autowired
	private CurrentCustomerSessionDao sDao;
	
	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private CurrentAdminSessionDao asDao;
	
	
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException{
		
		
		Customers existingUser= cDao.findByMobile(dto.getMobileNo());
		
		if(existingUser == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}
		
		Optional<CurrentCustomerSession> validUserSessionOpt =  sDao.findById(existingUser.getId());
		
		if(validUserSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentCustomerSession currentUserSession = new CurrentCustomerSession(existingUser.getId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
	}


	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentCustomerSession validUserSession = sDao.findByUuid(key);
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this key");
		}
		
		sDao.delete(validUserSession);
		
		return "Logged Out !";
		
	}


	@Override
	public String logIntoAdminAccount(LoginDTO dto) throws LoginException {
		Admin existingAdmin= aDao.findByMobile(dto.getMobileNo());
		
		if(existingAdmin == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}
		
		Optional<CurrentAdminSession> validAdminSessionOpt =  asDao.findById(existingAdmin.getAdminId());
		
		if(validAdminSessionOpt.isPresent()) {
			
			throw new LoginException("Admin already Logged In with this number");
			
		}
		
		if(existingAdmin.getAdminPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			
			asDao.save(currentAdminSession);

			return currentAdminSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
	}


	@Override
	public String logOutFromAdminAccount(String key) throws LoginException {
		CurrentAdminSession validAdminSession = asDao.findByUuid(key);
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this number");
		}
		
		asDao.delete(validAdminSession);
		
		return "Logged Out !";
	}

}
