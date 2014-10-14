package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Checkout;

public class CheckoutDaoImpl extends AbstractBaseDao implements CheckoutDao {

	public void addOrder(Checkout order) {
		super.add(order);
	}

	public void removeOrder(Checkout order) {
		super.remove(order);
	}

	public List<Checkout> listOrders() {
		return (List<Checkout>) super.getAll(Checkout.class);
	}

	public void updateOrder(Checkout order) {
		super.update(order);
	}

	public Checkout getOrderById(int id) {
		return (Checkout) super.getById(Checkout.class, id);
	}

}
