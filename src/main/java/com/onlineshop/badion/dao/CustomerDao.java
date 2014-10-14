package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Customer;


public interface CustomerDao {

	public void addCustomer(Customer customer);
	public void removeCustomer(Customer customer);
	public List<Customer> listCustomer();
	public void updateCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public Customer getCustomerByLogin(String login);
	public Customer getCustomerByEmail(String email);
}
