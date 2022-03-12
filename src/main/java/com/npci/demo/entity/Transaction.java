package com.npci.demo.entity;

import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_Id")
	private int transaction_Id;
	private Date trans_date;
	private float trans_amount;
	private int from_customer_Id;
	private int to_customer_Id;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transaction_Id, Date trans_date, float trans_amount, int from_customer_Id,
			int to_customer_Id) {
		super();
		this.transaction_Id = transaction_Id;
		this.trans_date = trans_date;
		this.trans_amount = trans_amount;
		this.from_customer_Id = from_customer_Id;
		this.to_customer_Id = to_customer_Id;
	}

	public int getTransaction_Id() {
		return transaction_Id;
	}

	public void setTransaction_Id(int transaction_Id) {
		this.transaction_Id = transaction_Id;
	}

	public Date getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(Date trans_date) {
		this.trans_date = trans_date;
	}

	public float getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(float trans_amount) {
		this.trans_amount = trans_amount;
	}

	public int getFrom_customer_Id() {
		return from_customer_Id;
	}

	public void setFrom_customer_Id(int from_customer_Id) {
		this.from_customer_Id = from_customer_Id;
	}

	public int getTo_customer_Id() {
		return to_customer_Id;
	}

	public void setTo_customer_Id(int to_customer_Id) {
		this.to_customer_Id = to_customer_Id;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_Id=" + transaction_Id + ", trans_date=" + trans_date + ", trans_amount="
				+ trans_amount + ", from_customer_Id=" + from_customer_Id + ", to_customer_Id=" + to_customer_Id + "]";
	}

}
