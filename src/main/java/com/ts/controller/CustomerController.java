package com.ts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ts.model.Customer;
import com.ts.service.CustomerService;
@CrossOrigin("*")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custser;
	@GetMapping("/msg")
	public String msg()
	{
		return "Hello"; 	
	}
	
	@GetMapping("/cus")
	
	public Customer cust()
	{
		return custser.cust();
			
	}

	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return custser.create(customer);
	}
	
	@GetMapping("/getall")
	public List<Customer> getallcust()
	{
		return custser.getallcust();
	}
	
	@DeleteMapping("/del")
	public Customer del(@RequestParam("id") Long id)
	{
		return custser.delete(id);
	}

	 @PutMapping("/custo")
	 public Customer upd(@RequestBody Customer cus,@RequestParam("id") Long id)
	 {
	 	return custser.update(cus,id);
	 }
}
