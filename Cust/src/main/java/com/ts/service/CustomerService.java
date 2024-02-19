package com.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.model.Customer;
import com.ts.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custrep;
	public Customer cust()
	{
		Customer customer=new Customer(1L,"sidd","Utage","Jule","Jule","Solapur","MH","s@gmail.com","1234");
	return customer;
	}
	

	public Customer createcustomer(Customer customer)
	{
		return custrep.save(customer);
	}


	public List<Customer> getallcustomers()
	{
		
		return custrep.findAll();
	}

	public Customer deletecust(Long id) {
		// TODO Auto-generated method stub
		custrep.deleteById(id);
		return null;
	}
	
	public Customer update(Customer cus,Long id)
	{
	return custrep.findById(id).map(Customer ->{
	Customer.setFirst_name(cus.getFirst_name());
	Customer.setLast_name(cus.getLast_name());
	Customer.setStreet(cus.getStreet());
	Customer.setAddress(cus.getAddress());
	Customer.setCity(cus.getCity());
	Customer.setState(cus.getState());
	Customer.setEmail(cus.getEmail());
	Customer.setPhone(cus.getPhone());
	return custrep.save(cus);
	})
	.orElseGet(()->{
		cus.setId(id);
		return custrep.save(cus);}
		);
	
	
	}
}

