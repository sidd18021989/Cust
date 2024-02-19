package com.ts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ts.model.Customer;
import com.ts.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService custser;
	@GetMapping("/mm")
	public String ms()
	{
		return "Hello";
	}
	
	@GetMapping("/cust")
	public Customer cust()
	
	{
	Customer cus=custser.cust();	
	return cus;
	}
	
	 @PostMapping("/create")
		public Customer createcustomer(@RequestBody Customer customer)
		{
			return custser.createcustomer(customer);
		}
	 

	    @GetMapping("/all")
	    public List<Customer> getall()
	    {
	    	return custser.getallcustomers();
	    }
	    
	
	@DeleteMapping("/del")
 public Customer del(@RequestParam("id") Long id)
 {
 	return custser.deletecust(id);
 }
 
 @PutMapping("/custo")
 public Customer upd(@RequestBody Customer cus,@RequestParam("id") Long id)
 {
 	return custser.update(cus,id);
 }

	
    

}
