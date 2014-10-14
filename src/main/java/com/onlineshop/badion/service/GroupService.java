package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Groupp;

public interface GroupService {

	public void addGroup(Groupp group);
	public void removeGroup(int id);
	public List<Groupp> listGroups();
	public void updateGroup(Groupp group);
	public Customer getGroupById(int id);
	public Groupp getGroupByName(String name);
	
}
