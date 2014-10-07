package com.onlineshop.badion.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Table;

import com.onlineshop.badion.service.RoleServiceImpl;

@Table(name="role")
public class Role {
	
	private Integer id;
	private String name;
	
	private static List<Role> listOfAll;
	private static HashMap<Integer, Role> mapById = new HashMap<Integer, Role>();
	private static HashMap<String, Role> mapByName = new HashMap<String, Role>();

	public static void initStaticFields() { }
	
	static {
		listOfAll = new RoleServiceImpl().getAll();
			for(Role role : listOfAll) {
				mapById.put(role.getId(), role);
				mapByName.put(role.getName(), role);
			}
	}
	
	public Role() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (((Role)obj).id.equals(this.id) ){
			return true;
		} else {
			return false;
		}	
	}
	
	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name
				+ "]";
	}
	
	public static List<Role> getAll(){
		return listOfAll;
	}
	
	public static Role getById(Integer id) {
		return mapById.get(id);
	}
	
	public static Role getByName(String name) {
		return mapByName.get(name);
	}
	

}
