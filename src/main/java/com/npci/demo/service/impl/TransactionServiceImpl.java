package com.npci.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.crudproject.Exception.ResourceNotFoundException;
import com.npci.demo.entity.Customers;
import com.npci.demo.entity.Transaction;
import com.npci.demo.repository.CustomerRepository;
import com.npci.demo.repository.TransactionRepository;
import com.npci.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Transaction getTransactionsDetailsById(int transaction_Id) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(transaction_Id).orElseThrow(
				() -> new ResourceNotFoundException("Transactions details not Found with Id: " + transaction_Id));
	}

	@Override
	public Transaction addTransaction(Transaction transaction) throws Exception {
		// TODO Auto-generated method stub

		int fromCustId = transaction.getFrom_customer_Id();
		int toCustId = transaction.getTo_customer_Id();
		float transAmount = transaction.getTrans_amount();

		Customers fromCustomer = customerRepository.getById(fromCustId);
		Customers toCustomer = customerRepository.getById(toCustId);

		float fbalance = fromCustomer.getBalance();

		if (fbalance >= transAmount) {
			fromCustomer.setBalance(fbalance - transAmount);
			customerRepository.save(fromCustomer);

			toCustomer.setBalance(toCustomer.getBalance() + transAmount);
			customerRepository.save(toCustomer);
		} else {
			throw new Exception("Insufficient Balance");
		}

		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransactionDetails() {
		// TODO Auto-generated method stub
		return (List<Transaction>) transactionRepository.findAll();
	}




}
