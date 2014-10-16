package com.onlineshop.badion.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.service.CustomerServiceImpl;

public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String login = request.getParameter("login");
		
		Customer customer = new Customer();
		HttpSession session = request.getSession();
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customer = (Customer) session.getAttribute("customer");
		

		if((fName != null) && (lName != null) 
				&& (phone != null) && (login != null)){
				
			customer.setFirstName(fName);
			customer.setLastName(lName);
			
			Customer customerByLogin = customerServiceImpl.getCustomerByLogin(login);
			Customer customerByPhone = customerServiceImpl.getCustomerByPhone(phone);
			
			if((customerByLogin != null) && (customer.getId() != customerByLogin.getId())) {
				request.setAttribute("sameLoginMessage", "Login error.");
			} else if((customerByPhone != null) && (customer.getId() != customerByPhone.getId())) {
				request.setAttribute("samePhoneMessage", "Phone error");
			} else {
				customer.setPhone(phone);
				response.sendRedirect("changePassword");
				customer.setLogin(login);
			}
		}
		customerServiceImpl.updateCustomer(customer);
		request.getRequestDispatcher("WEB-INF/pages/userProfile.jsp").include(request, response);

}
}
