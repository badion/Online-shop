package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Groupp;

public interface GroupDao {

	public void addGroup(Groupp group);
	public void removeGroup(Groupp group);
	public List<Groupp> listGroups();
	public void updateGroup(Groupp group);
	public Groupp getGroupById(int id);
	public Groupp getGroupByName(String name);
}
