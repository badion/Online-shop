package com.onlineshop.badion.service;

import java.util.List;

import javax.transaction.Transactional;

import com.onlineshop.badion.dao.CustomerDaoImpl;
import com.onlineshop.badion.model.Customer;


public class CustomerServiceImpl implements CustomerService {

	CustomerDaoImpl customerDao = new CustomerDaoImpl();
	
	public void setCustomerDao(CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}

	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDao.removeCustomer(id);
	}

	@Transactional
	public List<Customer> listCustomer() {
		return this.customerDao.listCustomer();
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		this.customerDao.updateCustomer(customer);
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDao.getCustomerById(id);
	}

	public Customer getCustomerByLogin(String login) {
		return customerDao.getCustomerByLogin(login);
	}

	public Customer getCustomerByEmail(String email) {
		return customerDao.getCustomerByEmail(email);
	}


}
