package com.onlineshop.badion.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineshop.badion.utils.HibernateUtil;

public class AbstractBaseDao {

	private Session session;
	private Transaction transaction;
	
	protected void remove(Object obj) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.delete(obj);
			transaction.commit();
			
		} catch (RuntimeException e) {
			try {
				transaction.rollback();
				} catch(RuntimeException rte) {
					// log can't roll back
				}
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	protected void add(Object obj) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(obj);
			transaction.commit();
			System.out.println("Add new user");
		} catch (RuntimeException e) {
			try {
				transaction.rollback();
				} catch(RuntimeException rte) {
					// log can't roll back
				}
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	protected void update(Object obj) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(obj);
			transaction.commit();
		} catch (RuntimeException e) {
			try {
				transaction.rollback();
				} catch(RuntimeException rte) {
					// log can't roll back
				}
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	protected List<?> getAll(Class clazz) {
		List objects = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM " + clazz.getName());
			objects = query.list();
			transaction.commit();
		} catch (RuntimeException e) {
			try {
				transaction.rollback();
				} catch(RuntimeException rte) {
					// log can't roll back
				}
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return objects;
	}
	
	protected Object getById(Class clazz, int id) {
        Object obj = null;
        try {
        	session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
            obj = session.get(clazz, id);
            transaction.commit();
        } catch (RuntimeException e) {
			try {
				transaction.rollback();
				} catch(RuntimeException rte) {
					// log can't roll back
				}
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return obj;
	}
}
