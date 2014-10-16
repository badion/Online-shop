package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.dao.PurchasedProductsDaoImpl;
import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.model.PurchasedProducts;

public class PurchasedProductsServiseImpl implements PurchasedProductsService {

	private PurchasedProductsDaoImpl daoImpl = new PurchasedProductsDaoImpl();
	
	public void add(PurchasedProducts product) {
		daoImpl.add(product);
	}

	public void remove(PurchasedProducts product) {
		daoImpl.remove(product);
	}

	public List<PurchasedProducts> listProducts() {
		return daoImpl.listProducts();
	}

	public void update(PurchasedProducts product) {
		daoImpl.update(product);
	}

	public List<PurchasedProducts> getById(Integer id) {
		return daoImpl.getById(id);
	}

	public Product getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
