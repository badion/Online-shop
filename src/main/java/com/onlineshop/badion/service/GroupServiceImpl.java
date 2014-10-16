package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.dao.GroupDaoImpl;
import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Groupp;

public class GroupServiceImpl implements GroupService {

	private GroupDaoImpl groupDao = new GroupDaoImpl();
	public void addGroup(Groupp group) {
		
	}

	public void removeGroup(int id) {
		
	}

	public List<Groupp> listGroups() {
		return groupDao.listGroups();
	}

	public void updateGroup(Groupp group) {
		
	}

	public Customer getGroupById(int id) {
		return null;
	}

	public Groupp getGroupByName(String name) {
		return groupDao.getGroupByName(name);
	}

	

}
