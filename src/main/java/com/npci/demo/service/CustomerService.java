package com.npci.demo.service;

import java.util.List; 

import org.springframework.stereotype.Service;
//import com.npci.customer_transaction_project.transaction_entity.Transaction;

import com.npci.demo.entity.Customers;

@Service
public interface CustomerService {

	public List<Customers> getAllCustomers();


	public Customers addOrUpdate(Customers customer) throws Exception;

	public Customers deleteCustomers(int customer_Id) throws Exception;

	public List<Customers> getCustomerByAge(int age);

	public List<Customers> getCustomerByFirstName(String first_name);

	public List<Customers> getCustomerByLastName(String last_name);


	public Customers getCustomersById(int customer_Id);
	
//	public Customers updateCustomerbyId(int customer_Id);

	


	
	
}
