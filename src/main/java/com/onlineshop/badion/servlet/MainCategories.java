package com.onlineshop.badion.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlineshop.badion.model.Groupp;
import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.service.GroupServiceImpl;
import com.onlineshop.badion.service.ProductServiceImpl;

public class MainCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GroupServiceImpl service = new GroupServiceImpl();
		List<Product> products = new ProductServiceImpl().getAll();
		request.setAttribute("products", products);
		List<Groupp> groups = service.listGroups();
		request.setAttribute("groups", groups);
		request.getRequestDispatcher("WEB-INF/pages/mainCategories.jsp")
				.forward(request, response);
	}

}
