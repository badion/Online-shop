package com.onlineshop.badion.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Double price;
	private String description;
	private Integer idGroup;
	private Integer quantity;
	//private Set<Checkout> checkout = new HashSet<Checkout>(0);
	
	
	public Product(Integer id, String name, Double price, String description,
			Integer idGroup, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.idGroup = idGroup;
		this.quantity = quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", idGroup=" + idGroup
				+ ", quantity=" + quantity + "]";
	}
	
	public Product() {
		super();
	}
}
