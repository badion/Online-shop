package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.model.Checkout;

public interface CheckoutService {

	public void addOrder(Checkout order);
	public void removeOrder(Checkout order);
	public List<Checkout> listOrders();
	public void updateOrder(Checkout order);
	public Checkout getOrderById(int id);
}
