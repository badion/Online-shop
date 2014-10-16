package com.onlineshop.badion.model;

public class CheckoutProduct {

	private Integer id;
	private Integer idCheckout;
	private Integer idProduct;

	public CheckoutProduct(Integer idCheckout, Integer idProduct) {
		super();
		this.idCheckout = idCheckout;
		this.idProduct = idProduct;
	}

	public CheckoutProduct() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCheckout() {
		return idCheckout;
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

	@Override
	public String toString() {
		return "CheckoutProduct [id=" + id + ", idCheckout=" + idCheckout
				+ ", idProduct=" + idProduct + "]";
	}

}
