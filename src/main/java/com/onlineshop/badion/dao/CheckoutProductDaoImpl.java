package com.onlineshop.badion.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineshop.badion.model.CheckoutProduct;
import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.utils.HibernateUtil;

public class CheckoutProductDaoImpl extends AbstractBaseDao implements CheckoutProductDao {

	public void addOrder(CheckoutProduct checoutProduct) {
		super.add(checoutProduct);
	}

	public void removeOrder(CheckoutProduct checoutProduct) {
		super.remove(checoutProduct);
	}

	public List<CheckoutProduct> listOrders() {
		return (List<CheckoutProduct>) super.getAll(CheckoutProduct.class);
	}

	public void updateOrder(CheckoutProduct checoutProduct) {
		super.update(checoutProduct);
	}

	public CheckoutProduct getOrderById(int id) {
		return (CheckoutProduct) super.getById(CheckoutProduct.class, id);
	}

	public CheckoutProduct getOrderByIdAndIdProduct(Integer idProduct, Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		CheckoutProduct checkoutProduct = null;
		
		try {
			transaction = session.beginTransaction();
			String hbrnQuery = "FROM CheckoutProduct WHERE id_product = :id_product AND id = :id";
			Query query = session.createQuery(hbrnQuery);
			query.setInteger("id_product", idProduct);
			query.setInteger("id", id);
			checkoutProduct = (CheckoutProduct) query.uniqueResult();
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return checkoutProduct;
	}

}
