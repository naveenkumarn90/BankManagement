package com.npci.demo.controller;

import java.util.List;  
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

import com.npci.crudproject.Exception.ResourceNotFoundException;
import com.npci.demo.entity.Customers;
import com.npci.demo.entity.Transaction;
import com.npci.demo.repository.CustomerRepository;
import com.npci.demo.service.CustomerService;
import com.npci.demo.service.TransactionService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/allcustomers")
	public ResponseEntity<List<Customers>> getAllCustomers() {
		List<Customers> customers = null;

		try {
			customers = customerService.getAllCustomers();
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbyId/{id}")
	public Customers getCustomerById(@PathVariable("id") int customer_Id) {

		Customers customers = null;

		customers = customerService.getCustomersById(customer_Id);

		return customers;
	}

	@PostMapping("/addorupdateCustomers")
	public ResponseEntity<Customers> addOrUpdate(@RequestBody Customers customer) {
		Customers customers = null;

		try {
			customers = customerService.addOrUpdate(customer);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	

	// delete the customer by Id
	@DeleteMapping("/deletecustomerbyId/{id}")
	public ResponseEntity<Customers> deleteCustomers(@PathVariable("id") int customer_Id) {
		Customers customers = null;

		try {
			customers = customerService.deleteCustomers(customer_Id);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbyage/{age}")
	public ResponseEntity<List<Customers>> getAllCustomerByAge(@PathVariable("age") int age) {
		List<Customers> customers = null;

		try {
			customers = customerService.getCustomerByAge(age);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbyfirst_name/{first_name}")
	public ResponseEntity<List<Customers>> getAllCustomerByFirstName(@PathVariable("first_name") String first_name) {
		List<Customers> customers = null;

		try {
			customers = customerService.getCustomerByFirstName(first_name);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbylast_name/{last_name}")
	public ResponseEntity<List<Customers>> getAllCustomerByLastName(@PathVariable("last_name") String last_name) {
		List<Customers> customers = null;

		try {
			customers = customerService.getCustomerByLastName(last_name);
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/gettransactiondetailsbyId/{id}")
	public Transaction getTransactionsDetailsById(@PathVariable("id") int transaction_Id) {

		Transaction transactions = null;

		transactions = transactionService.getTransactionsDetailsById(transaction_Id);

		return transactions;
	}

	@GetMapping("/getalltransactiondetails")
	public ResponseEntity<List<Transaction>> getAllTransactionDetails() {
		List<Transaction> transactions = null;

		try {
			transactions = transactionService.getAllTransactionDetails();
		} catch (Exception e) {
			e.getMessage();
		}
	
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	@PostMapping("/addtransactions")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transactions) {
		Transaction transaction = null;

		try {
			transaction = transactionService.addTransaction(transactions);
		} catch (Exception e) {
			e.getStackTrace();
		}

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomerbyId/{id}")
	public Customers updateCustomerbyId(@PathVariable(value="id") Integer customer_Id, @RequestBody Customers customer) {
		Customers customers = customerRepository.findById(customer_Id).orElseThrow(() -> new ResourceNotFoundException("Customer not exist in DB with this Id: "+customer_Id));
		
//		customers.setFirst_name(customer.getFirst_name());
//		customers.setLast_name(customer.getLast_name());
//		customers.setPan_number(customer.getPan_number());
		customers.setAddress(customer.getAddress());
		customers.setAge(customer.getAge());
		customers.setEmail(customer.getEmail());
		customers.setPhonenumber(customer.getPhonenumber());
		
		final Customers updatedCustomers =customerRepository.save(customers);
		
		return updatedCustomers ;
	}

}
