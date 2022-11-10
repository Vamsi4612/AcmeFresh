package com.acmefresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.entites.LoginDTO;
import com.acmefresh.service.LoginService;
import com.masai.exceptions.LoginException;

@RestController
public class LoginController {

	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/customer/login")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoAccount(dto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	@PostMapping("/customer/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		return customerLogin.logOutFromAccount(key);
		
	}
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> logInAdmin(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = customerLogin.logIntoAdminAccount(dto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	@PostMapping("/admin/logout")
	public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
		return customerLogin.logOutFromAdminAccount(key);
		
	}
	
	
	
}
