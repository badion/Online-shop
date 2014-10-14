package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public void removeProduct(Product product);
	public List<Product> listProducts();
	public void updateProduct(Product product);
	public List<Product> getProductByIdGroup(Integer id);
	public Product getProductByName(String name);
	public Product getProductById(int id);
}
