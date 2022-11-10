package com.acmefresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.dao.AutomationTechniquesDao;
import com.acmefresh.entites.AutomationTechniques;
import com.masai.exceptions.AutomationTechniquesException;

@Service
public class AutomationTechniquesServiceImpl implements AutomationTechniquesService{
	@Autowired
	private AutomationTechniquesDao customerDao;
	
	@Override
	public AutomationTechniques addNewAutomationTechniques(AutomationTechniques automationTechniques) throws AutomationTechniquesException {
		
		if(automationTechniques!=null) {
			AutomationTechniques c = customerDao.save(automationTechniques);
			return c;
		}
		else {
			throw new AutomationTechniquesException("Input AutomationTechniques details are not valid");
		}
		
	}

	@Override
	public AutomationTechniques getAutomationTechniquestById(Integer automationTechniquesId) throws AutomationTechniquesException {
		Optional<AutomationTechniques> opt = customerDao.findById(automationTechniquesId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new AutomationTechniquesException("No AutomationTechniques present with id : "+automationTechniquesId);
		}
	}

	@Override
	public List<AutomationTechniques> getAllAutomationTechniquess() throws AutomationTechniquesException {
		List<AutomationTechniques> list = customerDao.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
			throw new AutomationTechniquesException("AutomationTechniques list is empty!");
		}
		
	}

	@Override
	public AutomationTechniques deleteAutomationTechniquesById(Integer automationTechniquesId) throws AutomationTechniquesException {
		Optional<AutomationTechniques> opt = customerDao.findById(automationTechniquesId);
		if(opt.isPresent()) {
			AutomationTechniques e = opt.get();
			customerDao.delete(e);
			return e;
		}
		else {
			throw new AutomationTechniquesException("No AutomationTechniques present with id : "+automationTechniquesId);
		}
	}

	@Override
	public AutomationTechniques updateAutomationTechniques(AutomationTechniques automationTechniques) throws AutomationTechniquesException {
		Optional<AutomationTechniques> opt = customerDao.findById(automationTechniques.getId());
		if(opt.isPresent()) {
			AutomationTechniques e = opt.get();
			customerDao.save(automationTechniques);
			return e; 
		}
		else {
			throw new AutomationTechniquesException("No AutomationTechniques present with given details");
		}
	}
	

}
