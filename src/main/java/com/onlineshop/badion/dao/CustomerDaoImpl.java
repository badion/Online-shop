package com.onlineshop.badion.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.utils.HibernateUtil;

public class CustomerDaoImpl extends AbstractBaseDao implements CustomerDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addCustomer(Customer customer) {
		super.add(customer);
		/*sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(customer);
			transaction.commit();
			System.out.println("Add new user");
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			
		}
*/	}
	

	public List<Customer> listCustomer() {
		return (List<Customer>) super.getAll(Customer.class);
	}

	public void updateCustomer(Customer customer) {
		super.update(customer);
		/*	Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.update(customer);
			session.getTransaction().commit();
		} catch(RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}*/
	
	}

	public Customer getCustomerById(int id) {
		return (Customer) super.getById(Customer.class, id);
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Customer customer = null;
		try {
			transaction = session.beginTransaction();
			String hbrnQuery = "FROM Customer WHERE id = :id";
			Query query = session.createQuery(hbrnQuery);
			query.setInteger("id", id);
			customer = (Customer) query.uniqueResult();
		} catch(RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return customer;*/
	}


	public Customer getCustomerByEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Customer customer = null;
		List<Customer> list = null;
		try {
			String hbrnQuery = "FROM Customer WHERE email = :email";
			Query query = session.createQuery(hbrnQuery);
			query.setString("email", email);
			customer = (Customer) query.uniqueResult();
		
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
}
