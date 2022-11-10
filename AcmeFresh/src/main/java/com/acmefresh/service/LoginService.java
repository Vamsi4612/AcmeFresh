package com.acmefresh.service;

import com.acmefresh.entites.LoginDTO;
import com.masai.exceptions.LoginException;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	
	public String logIntoAdminAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAdminAccount(String key)throws LoginException;

}
