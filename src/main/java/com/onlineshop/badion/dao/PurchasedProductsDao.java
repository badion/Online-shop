package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.model.PurchasedProducts;

public interface PurchasedProductsDao {

	public void add(PurchasedProducts product);
	public void remove(PurchasedProducts product);
	public List<PurchasedProducts> listProducts();
	public void update(PurchasedProducts product);
	public List<PurchasedProducts> getById(Integer id);
	public Product getByName(String name);
	public Product getById(int id);
}
