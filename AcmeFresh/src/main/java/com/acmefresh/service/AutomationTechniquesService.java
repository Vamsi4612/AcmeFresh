package com.acmefresh.service;

import java.util.List;

import com.acmefresh.entites.AutomationTechniques;
import com.masai.exceptions.AutomationTechniquesException;

public interface AutomationTechniquesService {
	public AutomationTechniques addNewAutomationTechniques(AutomationTechniques AutomationTechniques)throws AutomationTechniquesException;
	
	public AutomationTechniques getAutomationTechniquestById(Integer AutomationTechniquesId)throws AutomationTechniquesException;
		
	public List<AutomationTechniques> getAllAutomationTechniquess()throws AutomationTechniquesException;
	
	public AutomationTechniques deleteAutomationTechniquesById(Integer AutomationTechniquesId)throws AutomationTechniquesException;
		
	public AutomationTechniques updateAutomationTechniques(AutomationTechniques AutomationTechniques)throws AutomationTechniquesException;
}
