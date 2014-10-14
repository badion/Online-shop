package com.onlineshop.badion.model;

import java.security.PublicKey;

public class CheckoutProduct {

	public CheckoutProduct() {
		
	}
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCheckout() {
		return idCheckout;
	}
	public CheckoutProduct(Integer idCheckout, Integer idProduct) {
		super();
		this.idCheckout = idCheckout;
		this.idProduct = idProduct;
	}
	public void setIdCheckout(Integer idCheckout) {
		this.idCheckout = idCheckout;
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	private Integer idCheckout;
	private Integer idProduct;
	@Override
	public String toString() {
		return "CheckoutProduct [id=" + id + ", idCheckout=" + idCheckout
				+ ", idProduct=" + idProduct + "]";
	}
	
	
}
