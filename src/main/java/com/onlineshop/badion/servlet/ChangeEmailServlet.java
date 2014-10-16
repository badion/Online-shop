package com.onlineshop.badion.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.service.CustomerServiceImpl;
import com.onlineshop.badion.utils.KeyEncryption;

public class ChangeEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession(true);
	Customer customer = new Customer();
	CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
	customer = (Customer) session.getAttribute("customer");

	if (customer != null) {
		String newMail = request.getParameter("mail");
		String oldMail = customer.getEmail();
		String password = request.getParameter("emailPass");
		String encodedPassword = KeyEncryption.getEncryptedKey(password,
				oldMail);
		String nullMessage = "empty password";

		request.setAttribute("nullMessage", nullMessage);

		if (encodedPassword.equals(customer.getPassword())) {
			if (customerServiceImpl.getCustomerByEmail(newMail) == null) {
				customer.setEmail(newMail);
				System.out.println(newMail);
				String newEncodedPassword = KeyEncryption.getEncryptedKey(
						password, newMail);
				System.out.println(password);
				customer.setPassword(newEncodedPassword);
				customerServiceImpl.updateCustomer(customer);
			} else {
				request.setAttribute(
						"msg",
						new Message("danger", "Error ", "Wrong email"));
			}

		} else {
			request.setAttribute(
					"msg",
					new Message("danger", "Error ", "Wrong password"));
		}
	}

	request.getRequestDispatcher(
			"WEB-INF/pages/userProfile.jsp").forward(request,
			response);
}
	}


