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

public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addCustomer(Customer customer) {
	
		sessionFactory = new Configuration().configure().buildSessionFactory();
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
	}
	
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		
		if(customer != null) {
			session.delete(customer);
		}
	}

	public List<Customer> listCustomer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from customer").list();
		
		for(Customer customer : customerList) {
			System.out.println("Customer list" + customer);
		}
		return customerList;
	}

	public void updateCustomer(Customer customer) {
		Transaction transaction = null;
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
		}
	
	}

	public Customer getCustomerById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
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
		return customer;
	}


	
		/*Customer customer = (Customer) session.load(Customer.class, login);
		try {
			transaction = session.beginTransaction();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}*/

	public Customer getCustomerByEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Customer customer = null;
		List<Customer> list = null;
		try {
			String hbrnQuery = "FROM Customer WHERE email = :email";
			Query query = session.createQuery(hbrnQuery);
			query.setString("email", email);
			//list = query2.list();
			customer = (Customer) query.uniqueResult();
			//customer = (Customer) query2.setResultTransformer(Transformers.aliasToBean(Customer.class));
			// String queryString =
			// "select * from customer where login = :login";
			// Query query = session.createQuery(queryString);
		//("getCustomerByLogin");
		
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return customer;
	}

	public Customer getCustomerByLogin(String login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = null;
		List<Customer> list = null;
		try {
			String hbrnQuery = "FROM Customer WHERE login = :login";
			Query query = session.createQuery(hbrnQuery);
			query.setString("login", login);
			customer = (Customer) query.uniqueResult();
			//customer = (Customer) query2.setResultTransformer(Transformers.aliasToBean(Customer.class));
			// String queryString =
			// "select * from customer where login = :login";
			// Query query = session.createQuery(queryString);
		//("getCustomerByLogin");
		
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			
		}
		return customer;
	}
}
