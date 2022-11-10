package com.acmefresh.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.entites.Customers;
import com.acmefresh.service.CustomerService;
import com.masai.exceptions.CustomersException;

@RestController
@RequestMapping("/customer")
public class CustomersController {

	@Autowired
	private CustomerService customersService;
	
	Logger logger = LoggerFactory.getLogger(CustomersController.class);
	
	@PostMapping("/create")
	public ResponseEntity<Customers> createCustomersController(@Valid @RequestBody Customers Customers,@RequestParam String key ) throws CustomersException {
		return new ResponseEntity<Customers>(customersService.addNewCustomers(Customers,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/customer/create
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customers> getCustomersByIdController(@PathVariable("id") Integer CustomersId,@RequestParam String key  ) throws CustomersException{
		return new ResponseEntity<Customers>(customersService.getCustomerstById(CustomersId,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/customer/5
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customers>> getAllCustomersController(@RequestParam String key ) throws CustomersException{
		return new ResponseEntity<List<Customers>>(customersService.getAllCustomerss(key),HttpStatus.ACCEPTED);
//		http://localhost:8080/customer/all
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customers> deleteCustomerController(@PathVariable("id") Integer CustomersId,@RequestParam String key ) throws CustomersException{
		return new ResponseEntity<Customers>(customersService.deleteCustomersById(CustomersId,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/customer/delete/4
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Customers> updateCustomerController(@Valid @RequestBody Customers Customers,@RequestParam String key) throws CustomersException {
		return new ResponseEntity<Customers>(customersService.updateCustomers(Customers,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/customer/update
	}
	
	
}





