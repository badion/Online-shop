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

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String oldPassword = request.getParameter("oldPassword");	
		String newPass = request.getParameter("newPass");
		String confirmPassword = request.getParameter("confirmPassword");

		Customer customer = new Customer();
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		HttpSession session = request.getSession(true);
		customer = (Customer) session.getAttribute("customer");
		
		if(customer != null) {
		String oldMail = customer.getEmail();
		String encodedPassword = KeyEncryption.getEncryptedKey(oldPassword, oldMail);

		if(encodedPassword.equals(customer.getPassword())) {
		if (newPass != null && confirmPassword != null)
			if (newPass.equals(confirmPassword)) {
				customer.setPassword(KeyEncryption.getEncryptedKey(newPass,
						customer.getEmail()));
				customerServiceImpl.updateCustomer(customer);
			}
		} else {
			request.setAttribute("msg", new Message("danger", "Error ", "Wrong password"));
		}
		}
		request.getRequestDispatcher(
				"WEB-INF/pages/userProfile.jsp").forward(request,
				response);
	
	}

}
