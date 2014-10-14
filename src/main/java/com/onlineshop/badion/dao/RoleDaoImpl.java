package com.onlineshop.badion.dao;

import java.util.ArrayList;
import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.model.Role;
import com.onlineshop.badion.utils.HibernateUtil;

public class RoleDaoImpl implements RoleDao {

	public List<Role> getAll() {
		List<Role> roleList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Role");
			roleList = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		for(Role role : roleList) {
			System.out.println("Product list" + role);
		}
		return roleList;
	}
}
