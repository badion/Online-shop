package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.dao.CheckoutDaoImpl;
import com.onlineshop.badion.model.Checkout;

public class CheckoutServiceImpl implements CheckoutService {

	private CheckoutDaoImpl orderDao = new CheckoutDaoImpl();
	
	public void addOrder(Checkout order) {
		orderDao.addOrder(order);
	}

	public void removeOrder(Checkout order) {
		orderDao.removeOrder(order);
	}

	public List<Checkout> listOrders() {
		return orderDao.listOrders();
	}

	public void updateOrder(Checkout order) {
		orderDao.updateOrder(order);
	}

	public Checkout getOrderById(int id) {
		return orderDao.getOrderById(id);
	}

	
}
