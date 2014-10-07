package com.onlineshop.badion.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onlineshop.badion.model.Role;

public class RoleDaoImpl implements RoleDao {

	public List<Role> getAll() {
		List<Role> roles = new ArrayList<Role>();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			roles = session.createQuery("select * from Role").list();
		} catch(RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return roles;
	}
}
