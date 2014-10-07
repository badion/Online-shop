package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.model.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer);
	public void removeCustomer(int id);
	public List<Customer> listCustomer();
	public void updateCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public Customer getCustomerByLogin(String login);
	public Customer getCustomerByEmail(String email);
	
}
