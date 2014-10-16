package com.onlineshop.badion.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineshop.badion.model.Groupp;
import com.onlineshop.badion.utils.HibernateUtil;

public class GroupDaoImpl extends AbstractBaseDao implements GroupDao {

	public void addGroup(Groupp group) {
		super.add(group);
	}

	public void removeGroup(Groupp group) {
		super.remove(group);
	}

	public List<Groupp> listGroups() {
		return (List<Groupp>) super.getAll(Groupp.class);
	}

	public void updateGroup(Groupp group) {
		super.update(group);
	}

	public Groupp getGroupById(int id) {
		return (Groupp) super.getById(Groupp.class, id);
	}

	public Groupp getGroupByName(String name) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Groupp group = null;
		try {
			String hbrnQuery = "FROM Groupp WHERE name = :name";
			transaction = session.beginTransaction();
			Query query = session.createQuery(hbrnQuery);
			query.setString("name", name);
			group = (Groupp) query.uniqueResult();
			transaction.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return group;
	}

}
