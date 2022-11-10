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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.entites.Sellers;
import com.acmefresh.service.SellersService;
import com.masai.exceptions.SellersException;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellersService sellersService;
	
	@PostMapping("/register")
	public ResponseEntity<Sellers> addSellerController(@Valid @RequestBody Sellers Sellers,@RequestParam String key) throws SellersException {
		return new ResponseEntity<Sellers>(sellersService.addNewSellers(Sellers,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/seller/register
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Sellers> deleteSellerController(@PathVariable("id") Integer SellersId,@RequestParam String key) throws SellersException{
		return new ResponseEntity<Sellers>(sellersService.deleteSellersById(SellersId,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/seller/delete/4
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Sellers> updateSellerController(@Valid @RequestBody Sellers Sellers,@RequestParam String key) throws SellersException {
		return new ResponseEntity<Sellers>(sellersService.updateSellers(Sellers,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/seller/update
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sellers> getSellerByIDController(@PathVariable("id") Integer SellersId,@RequestParam String key) throws SellersException{
		return new ResponseEntity<Sellers>(sellersService.getSellerstById(SellersId,key),HttpStatus.ACCEPTED);
//		http://localhost:8080/seller/5
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Sellers>> getAllSellersController(@RequestParam String key) throws SellersException{
		return new ResponseEntity<List<Sellers>>(sellersService.getAllSellerss(key),HttpStatus.ACCEPTED);
//		http://localhost:8080/seller/all
	}
	
	
	
}






