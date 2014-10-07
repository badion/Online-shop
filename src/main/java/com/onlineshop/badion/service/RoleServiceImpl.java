package com.onlineshop.badion.service;

import java.util.List;

import com.onlineshop.badion.dao.RoleDaoImpl;
import com.onlineshop.badion.model.Role;

public class RoleServiceImpl implements RoleService {

	RoleDaoImpl roleDao = new RoleDaoImpl();
	public List<Role> getAll() {
		return roleDao.getAll();
	}

}
