package com.onlineshop.badion.servlet.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.service.CustomerServiceImpl;

public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Customer customer = new CustomerServiceImpl().getCustomerById(id);
		
		if(customer != null) {
			customer.setEmailConfirmed(true);
			new CustomerServiceImpl().updateCustomer(customer);
			session.setAttribute("customer", customer);
			request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
		}
	}

}
