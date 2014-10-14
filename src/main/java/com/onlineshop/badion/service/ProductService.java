package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.model.Product;


public interface ProductService {

	public void updateProduct(Product product);
	public void addProduct(Product product);
	public List<Product> getAll();
	public Product getProductByName(String name);
	public List<Product> getProductByIdGroup(Integer id);
	public Product getProductById(int id);
	public void removeProduct(Product product);
}
