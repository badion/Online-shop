package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.dao.CustomerDaoImpl;
import com.onlineshop.badion.model.Customer;


public class CustomerServiceImpl implements CustomerService {

	CustomerDaoImpl customerDao = new CustomerDaoImpl();
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	public List<Customer> listCustomer() {
		return customerDao.listCustomer();
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	public Customer getCustomerById(int id) {
		return this.customerDao.getCustomerById(id);
	}

	public Customer getCustomerByLogin(String login) {
		return customerDao.getCustomerByLogin(login);
	}

	public Customer getCustomerByEmail(String email) {
		return customerDao.getCustomerByEmail(email);
	}

	public void removeCustomer(Customer customer) {
		customerDao.removeCustomer(customer);
	}

	public Customer getCustomerByPhone(String phone) {
		return customerDao.getCustomerByPhone(phone);
	}


}
