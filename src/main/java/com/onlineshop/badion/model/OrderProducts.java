package com.onlineshop.badion.model;

public class OrderProducts {

	private Integer idProduct;
	private Integer idOrder;
	
	public OrderProducts(Integer idProduct, Integer idOrder) {
		super();
		this.idProduct = idProduct;
		this.idOrder = idOrder;
	}
	
	public OrderProducts() {
		super();
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	
	@Override
	public String toString() {
		return "OrderProducts [idProduct=" + idProduct + ", idOrder=" + idOrder
				+ "]";
	}
}
