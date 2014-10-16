package com.onlineshop.badion.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.utils.HibernateUtil;

public class ProductDaoImpl extends AbstractBaseDao implements ProductDao {

	public void addProduct(Product product) {
		super.add(product);
	}

	public void removeProduct(Product product) {
		super.remove(product);
	}
	
	public List<Product> listProducts() {
		return (List<Product>) super.getAll(Product.class);
	}

	public void updateProduct(Product product) {
		super.update(product);
	}

	
	public List<Product> getProductByIdGroup(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Product> product = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Product WHERE id_group = :id_group");
			query.setInteger("id_group", id);
			product = query.list();
			transaction.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return product;
	}

	public Product getProductByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Product product = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Product WHERE name = :name");
			query.setString("name", name);
			product = (Product) query.uniqueResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return product;
	}

	public Product getProductById(int id) {
		return (Product) super.getById(Product.class, id);
	}
}
