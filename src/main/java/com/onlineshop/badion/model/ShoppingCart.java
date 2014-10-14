package com.onlineshop.badion.model;

import java.util.List;

public class ShoppingCart {
	
	private Integer idCheckoutProduct;
	private String name;
	private String description;
	private Double price;
	private Double totalPrice;
	private Integer idProduct;
	private Integer idCheckout;
	private Integer idGroup;
	private Integer idCustomer;
	
	public ShoppingCart(Integer idCheckoutProduct, String name,
			String description, Double price, Double totalPrice,
			Integer idCustomer, Integer idProduct, Integer idCheckout, Integer quantity, Integer idGroup) {
		super();
		this.idCustomer = idCustomer;
		this.idCheckoutProduct = idCheckoutProduct;
		this.name = name;
		this.description = description;
		this.price = price;
		this.totalPrice = totalPrice;
		this.idProduct = idProduct;
		this.idCheckout = idCheckout;
		this.quantity = quantity;
		this.idGroup = idGroup;
	}
	
	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public Integer getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	private Integer quantity;
	@Override
	public String toString() {
		return "ShoppingCart [idCheckoutProduct=" + idCheckoutProduct
				+ ", name=" + name + ", description=" + description
				+ ", price=" + price + ", totalPrice=" + totalPrice
				+ ", idProduct=" + idProduct + ", idCheckout=" + idCheckout
				+ ", quantity=" + quantity
				+ ", idGroup= " + idGroup
				+ ", idCustomer= " + idCustomer + "]";
	}	
	public Integer getIdCheckoutProduct() {
		return idCheckoutProduct;
	}
	public void setIdCheckoutProduct(Integer idCheckoutProduct) {
		this.idCheckoutProduct = idCheckoutProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public Integer getIdCheckout() {
		return idCheckout;
	}
	public void setIdCheckout(Integer idCheckout) {
		this.idCheckout = idCheckout;
	}
	
	
	public ShoppingCart() {
	}
}