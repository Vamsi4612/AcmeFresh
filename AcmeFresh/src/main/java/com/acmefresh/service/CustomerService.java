package com.acmefresh.service;

import java.util.List;

import com.acmefresh.entites.Customers;
import com.masai.exceptions.CustomersException;

public interface CustomerService {
	public Customers addNewCustomers(Customers Customers,String key)throws CustomersException;
	
	public Customers getCustomerstById(Integer CustomersId,String key)throws CustomersException;
		
	public List<Customers> getAllCustomerss(String key)throws CustomersException;
	
	public Customers deleteCustomersById(Integer CustomersId,String key)throws CustomersException;
		
	public Customers updateCustomers(Customers Customers,String key)throws CustomersException;
}
