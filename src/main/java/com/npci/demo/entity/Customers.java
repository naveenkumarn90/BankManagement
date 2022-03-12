package com.npci.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_Id")
	private int customer_Id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email")
	private String email;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "pan_number")
	private String pan_number;

	@Column(name = "age")
	private int age;

	@Column(name = "address")
	private String address;

	@Column(name = "balance")
	private float balance;

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(int customer_Id, String first_name, String last_name, String email, String phonenumber,
			String pan_number, int age, String address, float balance) {
		super();
		this.customer_Id = customer_Id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.pan_number = pan_number;
		this.age = age;
		this.address = address;
		this.balance = balance;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPan_number() {
		return pan_number;
	}

	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customers [customer_Id=" + customer_Id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", pan_number=" + pan_number + ", age=" + age
				+ ", address=" + address + ", balance=" + balance + "]";
	}

}
