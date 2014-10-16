package com.onlineshop.badion.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.service.CustomerServiceImpl;
import com.onlineshop.badion.utils.KeyEncryption;

public class AuthorizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static Logger LOG = Logger.getLogger(AuthorizationServlet.class);   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");
		LOG.info("In AuthorizationServlet");
			if(customer != null) {
				if(request.getParameter("log_out_button") != null) {
					cleanSessionAttr(session);
				}
				response.sendRedirect("home");
			} else if(request.getParameter("authorization_button") != null) {
				customer = authorizateCustomer(request, response);
				if(customer != null) {
					session.setAttribute("customer", customer);
					
					String currentPage = request.getHeader("Referer").substring(getRootDomain(request).length());
					response.sendRedirect(currentPage);
					} else {
						request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
					}
 				} else {
 					String currentURL = request.getHeader("Referer").substring(getRootDomain(request).length());
 					response.sendRedirect(currentURL);
 				}
			}
			
	

	private String getRootDomain(HttpServletRequest request) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(request.getScheme());
		builder.append("://");
		builder.append(request.getServerName());
		builder.append(":");
		builder.append(request.getServerPort());
		builder.append(request.getContextPath());
		builder.append("/");
		
		return builder.toString();
	}

	private Customer authorizateCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		if((login == null) || (login.equals("")))  {
			request.setAttribute("msg", new Message("danger", "Authorization error", "Please enter login."));
			return null;
		}
		
		if((password == null) || (password.equals(""))) {
			session.setAttribute("session_login", login);
			request.setAttribute("msg", new Message("danger", "Authorization error", "Please enter password."));
			return null;
		}
		
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		Customer customer = customerService.getCustomerByLogin(login);
		
		
		if(customer == null) {
			session.setAttribute("session_login", session);
			request.setAttribute("msg", new Message("danger", "Authorization error", "Login or password are wrong"));
			return null;
		}
		
		if (checkPass(customer, password) == false){
			// pass is not correct
			// ERROR MASSAGE
			session.setAttribute("session_login", login);
			request.setAttribute("msg", new Message("danger", "Authorization error", "Login or password are wrong"));
			return null;
		}
		
		if (customer.getEmailConfirmed() == false){
			// mail is not confirm
			// ERROR MASSAGE
			session.setAttribute("session_login", login);
			request.setAttribute("msg", new Message("danger", "Authorization error", "Your mail is not confirmed. Please confirm your mail to login."));
			return null;			
		}
		
		if (customer.getLocked() == true){
			// you are locked
			// ERROR MASSAGE
			session.setAttribute("session_login", login);
			request.setAttribute("msg", new Message("danger", "Authorization error", "Your account is blocked"));
			return null;			
		}
		
		return customer;
	}
	
	private boolean checkPass(Customer customer, String password){
		password = KeyEncryption.getEncryptedKey(password, customer.getEmail());
	
		if (password.equals(customer.getPassword())){
			return true;
		}
		else{
			return false;
		}
	}
	
	private void cleanSessionAttr(HttpSession session) {
		Enumeration<String> atrributesNamesEnumeration = session
				.getAttributeNames();
		while (atrributesNamesEnumeration.hasMoreElements()) {
			String attrName = atrributesNamesEnumeration.nextElement();
				session.removeAttribute(attrName);
			}
		}
	}
