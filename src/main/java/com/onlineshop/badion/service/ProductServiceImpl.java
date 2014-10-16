package com.onlineshop.badion.service;

import java.util.List;


import com.onlineshop.badion.dao.ProductDaoImpl;
import com.onlineshop.badion.model.Product;

public class ProductServiceImpl implements ProductService {

	private ProductDaoImpl productDao = new ProductDaoImpl();

	public List<Product> getAll() {
		return productDao.listProducts();
	}

	public Product getProductByName(String name) {
		return productDao.getProductByName(name);
	}

	public List<Product> getProductByIdGroup(Integer id) {
		return productDao.getProductByIdGroup(id);
	}

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void removeProduct(Product product) {
		productDao.removeProduct(product);
	}

}
