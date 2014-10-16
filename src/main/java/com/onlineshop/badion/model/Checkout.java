package com.onlineshop.badion.model;

import java.util.Date;

public class Checkout {

	private Integer id;
	private Integer idCustomer;
	private Date date;
	private Double priceSum;
	private String orderStatus;

	public Checkout(Integer id, Integer idCustomer, Date date, Double priceSum,
			String orderStatus) {
		super();
		this.id = id;
		this.idCustomer = idCustomer;
		this.date = date;
		this.priceSum = priceSum;
		this.orderStatus = orderStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(Double priceSum) {
		this.priceSum = priceSum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Checkout() {
		super();
	}

	@Override
	public String toString() {
		return "Checkout [id=" + id + ", idCustomer=" + idCustomer + ", date="
				+ date + ", priceSum=" + priceSum + ", orderStatus=";
	}
}
