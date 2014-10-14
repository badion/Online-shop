package com.onlineshop.badion.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineshop.badion.model.Checkout;
import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.service.CheckoutServiceImpl;
import com.onlineshop.badion.service.ProductServiceImpl;
import com.onlineshop.badion.utils.HibernateUtil;

public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Customer customer;
	private Product product;
	private Checkout checkout = new Checkout();
	private Date today = new Date();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idProduct = request.getParameter("productId");
		HttpSession session = request.getSession(true);
		if (session.getAttribute("customer") != null) {
				
			Set<Checkout> checkSet = new HashSet<Checkout>();
			Session sessionH = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = sessionH.beginTransaction();
			product = (Product) sessionH.get(Product.class,
					Integer.parseInt(idProduct));
			customer = (Customer) session.getAttribute("customer");
			checkout.setIdCustomer(customer.getId());
			checkout.setDate(today);
			checkout.setOrderStatus("processing");
			checkSet.add(checkout);
		//	product.setCheckout(checkSet);
			sessionH.save(product);
			transaction.commit();
			sessionH.close();

		} else {
			request.setAttribute("msg", new Message("danger", "Error ",
					"You must login before you order."));
			request.getRequestDispatcher("mainCategories").forward(request,
					response);
		}
	}

}
