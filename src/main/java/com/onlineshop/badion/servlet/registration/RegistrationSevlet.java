package com.onlineshop.badion.servlet.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.message.SendHTMLEmail;
import com.onlineshop.badion.service.CustomerServiceImpl;
import com.onlineshop.badion.servlet.registration.FullUrl;
import com.onlineshop.badion.utils.KeyEncryption;

public class RegistrationSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile(
			"(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}",
			Pattern.CASE_INSENSITIVE);

	public static final Pattern VALID_USER = Pattern.compile(
			"/^[a-яіїєА-ЯІЇЄa-zA-Z_-]+$/", Pattern.CASE_INSENSITIVE);

	public static final Pattern VALID_LOGIN_REGEX = Pattern.compile(
			"^[a-яіїєА-ЯІЇЄa-zA-Z0-9_-]+$",
			Pattern.CASE_INSENSITIVE);
	
	private boolean validation(HttpServletRequest request,
			HttpServletResponse response, StringBuilder msg, String nameOfParam,
			Pattern pattern, String errorMessage, Boolean isValidate) {
		
		isValidate = true;
		
		if(request.getParameter(nameOfParam) != null) {
			if(!pattern.matcher(request.getParameter(nameOfParam)).matches()) {
				msg.append(errorMessage);
				isValidate = false;
			}
		} else {
			msg.append(errorMessage);
			isValidate = false;
		}
		return isValidate;
	}
	
	public boolean validatePassword(HttpServletRequest request, StringBuilder msg, Boolean isValidate) {
		if (request.getParameter("password").length() < 6
				|| request.getParameter("password").length() > 32) {
			msg.append("The passord has to be between 6 and 32 characters");
			isValidate = false;
		}

		if (request.getParameter("repeatPassword") == null
				|| !(request.getParameter("repeatPassword").equals(request
						.getParameter("password")))) {
			msg.append("Your confirm passord is not equals your password");
			isValidate = false;
		}
		return isValidate;
	}
	public boolean validate(HttpServletRequest request,
			HttpServletResponse response, StringBuilder msg) {
		Boolean isValidate = null;
		isValidate = validation(request, response, msg, "email", VALID_EMAIL_ADDRESS_REGEX, "Mail adress is incorrect.", isValidate); 
		isValidate = validation(request, response, msg, "phone", VALID_PHONE_NUMBER_REGEX, "Phone number is incorrect.", isValidate); 
		isValidate = validation(request, response, msg, "firstName", VALID_USER, "Please insert your first name.", isValidate);
		isValidate = validation(request, response, msg, "lastName", VALID_USER, "Please insert your last name.", isValidate); 
		isValidate = validation(request, response, msg, "login", VALID_LOGIN_REGEX, "Please insert your login.", isValidate); 
		
		isValidate = validatePassword(request, msg, isValidate);

		return isValidate;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder msg = new StringBuilder();
		StringBuilder loginned = new StringBuilder();

		loginned.append("This user is already exist.");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("phone", phone);
		request.setAttribute("login", login);
		request.setAttribute("password", password);
		request.setAttribute("email", email);
		
		
		Customer customerLogin = new CustomerServiceImpl()
		.getCustomerByLogin(login);
		Customer customerMail = new CustomerServiceImpl()
		.getCustomerByEmail(email);

		Customer customerCheck = new Customer();
		Boolean canCreate = true;
		if(validate(request, response, msg)) {
			if (customerLogin != null) {
				if (login.equals(customerLogin.getLogin())) {
					canCreate = false;
			}
		}

		if (customerMail != null) {
			System.out.println(customerMail);
			if (email.equals(customerMail.getEmail())) {
				canCreate = false;
			}
		}
		System.out.println("canCreate" + canCreate);
		if (canCreate) {
			customerCheck.setFirstName(firstName);
			customerCheck.setLastName(lastName);
			customerCheck.setIdRole(1);
			customerCheck.setEmail(email);
			customerCheck.setLogin(login);
			customerCheck.setPhone(phone);
			customerCheck.setPassword(KeyEncryption.getEncryptedKey(password,
					email));
			customerCheck.setLocked(false);
			customerCheck.setEmailConfirmed(false);
			new CustomerServiceImpl().addCustomer(customerCheck);
			System.out.println(customerCheck.getId());
			customerCheck.setPassword(password);

				/**
				 * Sending mail.. 
				 */
						String serverUrl = FullUrl.get(request);
						try {
							SendHTMLEmail.send(customerCheck, serverUrl);
							request.getRequestDispatcher("home").include(request,
									response);
						} catch (AddressException e) {
							e.printStackTrace();
						} catch (MessagingException e) {
							e.printStackTrace();
						}
				PrintWriter out = response.getWriter();
				out.println(" <script> alert('User successfully registered');"
						+ "</script>");
				out.close();

			} else {
				request.getRequestDispatcher("WEB-INF/pages/index.jsp").include(request,
						response);
				PrintWriter out = response.getWriter();
				out.println(" <script> alert('" + loginned + "');"
						+ "</script>");
				out.close();
			}

		} else {
			request.getRequestDispatcher("WEB-INF/pages/registration.jsp").include(request, response);
			PrintWriter out = response.getWriter();
			out.println(" <script> alert('" + msg + "');"
					+ "</script>");
			out.close();
		}
			
		}
	}


