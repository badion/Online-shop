package com.onlineshop.badion.model;

public class Groupp {
	
	private String name;
	private Integer id;

	public Groupp(Integer id,  String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Groupp() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Group, name=" + name + " " + id + " + id. ";
	}


}
