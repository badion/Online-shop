package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public void removeProduct(int id);
	public List<Product> listProducts();
	public void updateProduct(Product product);
	public Customer getProductById(int id);
}
