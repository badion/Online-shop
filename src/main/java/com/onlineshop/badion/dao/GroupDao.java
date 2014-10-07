package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Group;

public interface GroupDao {

	public void addGroup(Group group);
	public void removeGroup(int id);
	public List<Group> listGroups();
	public void updateGroup(Group group);
	public Customer getGroupById(int id);
}
