package com.onlineshop.badion.dao;

import java.util.List;

import com.onlineshop.badion.model.Role;

public class RoleDaoImpl extends AbstractBaseDao implements RoleDao {

	public List<Role> getAll() {
		return (List<Role>) super.getAll(Role.class);
	}
}
