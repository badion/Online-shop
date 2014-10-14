package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Checkout;
import com.onlineshop.badion.model.CheckoutProduct;

public interface CheckoutProductDao {
	public void addOrder(CheckoutProduct checoutProduct);
	public void removeOrder(CheckoutProduct checoutProduct);
	public List<CheckoutProduct> listOrders();
	public void updateOrder(CheckoutProduct checoutProduct);
	public CheckoutProduct getOrderById(int id);
	public CheckoutProduct getOrderByIdAndIdProduct(Integer idProduct, Integer id);
}
