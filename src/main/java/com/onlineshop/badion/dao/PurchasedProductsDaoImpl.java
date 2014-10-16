package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.model.PurchasedProducts;

public class PurchasedProductsDaoImpl extends AbstractBaseDao implements PurchasedProductsDao {

	public void add(PurchasedProducts product) {
		super.add(product);
	}

	public void remove(PurchasedProducts product) {
		super.remove(product);
	}

	public List<PurchasedProducts> listProducts() {
		return (List<PurchasedProducts>) super.getAll(PurchasedProducts.class);
	}

	public void update(PurchasedProducts product) {
		super.update(product);
	}

	public List<PurchasedProducts> getById(Integer id) {
		return (List<PurchasedProducts>) super.getById(PurchasedProducts.class, id);
	}

	public Product getByName(String name) {
		return null;
	}

	public Product getById(int id) {
		return null;
	}

}
