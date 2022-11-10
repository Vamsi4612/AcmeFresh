package com.acmefresh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.entites.AutomationTechniques;
import com.acmefresh.service.AutomationTechniquesService;
import com.masai.exceptions.AutomationTechniquesException;

@RestController
@RequestMapping("/technique")
public class AutomationTechniqusController {
	
	@Autowired
	private AutomationTechniquesService eService;
	
	@PostMapping("/add")
	public ResponseEntity<AutomationTechniques> saveAutomationTechniques(@Valid @RequestBody AutomationTechniques AutomationTechniques) throws AutomationTechniquesException {
		return new ResponseEntity<AutomationTechniques>(eService.addNewAutomationTechniques(AutomationTechniques),HttpStatus.ACCEPTED);
//		http://localhost:8080/technique/add
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutomationTechniques> getAutomationTechniques(@PathVariable("id") Integer AutomationTechniquesId ) throws AutomationTechniquesException{
		return new ResponseEntity<AutomationTechniques>(eService.getAutomationTechniquestById(AutomationTechniquesId),HttpStatus.ACCEPTED);
//		http://localhost:8080/technique/5
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AutomationTechniques>> getAllAutomationTechniques() throws AutomationTechniquesException{
		return new ResponseEntity<List<AutomationTechniques>>(eService.getAllAutomationTechniquess(),HttpStatus.ACCEPTED);
//		http://localhost:8080/technique/all
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AutomationTechniques> deleteAutomationTechniques(@PathVariable("id") Integer AutomationTechniquesId ) throws AutomationTechniquesException{
		return new ResponseEntity<AutomationTechniques>(eService.deleteAutomationTechniquesById(AutomationTechniquesId),HttpStatus.ACCEPTED);
//		http://localhost:8080/technique/delete/4
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<AutomationTechniques> updateAutomationTechniques(@Valid @RequestBody AutomationTechniques AutomationTechniques) throws AutomationTechniquesException {
		return new ResponseEntity<AutomationTechniques>(eService.updateAutomationTechniques(AutomationTechniques),HttpStatus.ACCEPTED);
//		http://localhost:8080/technique/update
	}
	
	
}





