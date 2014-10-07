package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Group;
import com.onlineshop.badion.model.OrderProducts;
import com.onlineshop.badion.model.Product;

public interface OrderProductsDao {

	public void addOrderProducts(OrderProducts orderProducts);
	public void removeOrderProducts(int id);
	public List<OrderProducts> listGroups();
	public void updateOrderProducts(OrderProducts orderProducts);
	public Customer getOrderProductsById(int id);
}
