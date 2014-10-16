package com.onlineshop.badion.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.badion.dao.PurchasedProductsDaoImpl;
import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.PurchasedProducts;
import com.onlineshop.badion.model.ShoppingCart;

public class OrderSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Double sum = Double.parseDouble(request.getParameter("sumToDb"));
		Customer customer = (Customer) session.getAttribute("customer");
		String shippingType = request.getParameter("ship");
		String country = request.getParameter("deliveryCountry");
		String address = request.getParameter("deliveryAddress");
		String city = request.getParameter("deliveryCity");
		List<ShoppingCart> shoppingList = (List<ShoppingCart>) session
				.getAttribute("prevProduct");
		Integer checkoutId = shoppingList.get(0).getIdCheckout();
		PurchasedProducts purchasedProducts = new PurchasedProducts(
				customer.getId(), shippingType, country, city, address,
				checkoutId, sum);

		new PurchasedProductsDaoImpl().add(purchasedProducts);
		session.removeAttribute("prevProduct");
		request.getRequestDispatcher("home").forward(request, response);

	}

}
