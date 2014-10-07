package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Order;

public interface OrderDao {

	public void addOrder(Order order);
	public void removeOrder(int id);
	public List<Order> listOrders();
	public void updateOrder(Order order);
	public Order getOrderById(int id);
}
