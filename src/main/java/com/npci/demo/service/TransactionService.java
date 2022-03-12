package com.npci.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.npci.demo.entity.Transaction;

@Service
public interface TransactionService {
	public Transaction getTransactionsDetailsById(int transaction_Id);

	public List<Transaction> getAllTransactionDetails();

	public Transaction addTransaction(Transaction transaction) throws Exception;
	
	

}

