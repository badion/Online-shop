package com.onlineshop.badion.model;

public class Group {
	
	private Integer product_id;
	private String name;
	private String description;
	private Integer id;

	public Group(Integer id, Integer product_id, String name, String description) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.name = name;
		this.description = description;
	}
	
	public Group() {
		super();
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Group [product_id=" + product_id + ", name=" + name
				+ ", description=" + description + ", id=" + id + "]";
	}


}
