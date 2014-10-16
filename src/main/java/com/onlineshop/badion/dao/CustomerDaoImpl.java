package com.onlineshop.badion.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.utils.HibernateUtil;

public class CustomerDaoImpl extends AbstractBaseDao implements CustomerDao {
	
	public void addCustomer(Customer customer) {
		super.add(customer);
	}

	public List<Customer> listCustomer() {
		return (List<Customer>) super.getAll(Customer.class);
	}

	public void updateCustomer(Customer customer) {
		super.update(customer);
	}

	public Customer getCustomerById(int id) {
		return (Customer) super.getById(Customer.class, id);
	}


	public Customer getCustomerByEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Customer customer = null;
		List<Customer> list = null;
		try {
			transaction = session.beginTransaction();
			String hbrnQuery = "FROM Customer WHERE email = :email";
			Query query = session.createQuery(hbrnQuery);
			query.setString("email", email);
			customer = (Customer) query.uniqueResult();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return customer;
	}

	public Customer getCustomerByLogin(String login) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Customer customer = null;
		try {
			String hbrnQuery = "FROM Customer WHERE login = :login";
			Query query = session.createQuery(hbrnQuery);
			query.setString("login", login);
			customer = (Customer) query.uniqueResult();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			
		}
		return customer;
	}

	public void removeCustomer(Customer customer) {
		super.remove(customer);
	}

	public Customer getCustomerByPhone(String phone) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Customer customer = null;
		try {
			String hbrnQuery = "FROM Customer WHERE phone = :phone";
			Query query = session.createQuery(hbrnQuery);
			query.setString("phone", phone);
			customer = (Customer) query.uniqueResult();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return customer;
	}
}
