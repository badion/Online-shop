package com.onlineshop.badion.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.badion.dao.CheckoutProductDaoImpl;
import com.onlineshop.badion.model.Checkout;
import com.onlineshop.badion.model.CheckoutProduct;
import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.model.ShoppingCart;
import com.onlineshop.badion.service.CheckoutServiceImpl;
import com.onlineshop.badion.service.ProductServiceImpl;

public class ClearCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CheckoutProductDaoImpl checkoutProductDao = new CheckoutProductDaoImpl();
	private CheckoutServiceImpl checkoutService = new CheckoutServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Checkout checkout = (Checkout) session.getAttribute("checkout"); 		//get Checkout
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Integer idCheckoutProduct = Integer.parseInt(request.getParameter("idChout"));
		Integer checkoutId = Integer.parseInt(request.getParameter("oid"));
		
		CheckoutProduct checkoutProduct = checkoutProductDao.getOrderByIdAndIdProduct(productId, idCheckoutProduct);
		
		Product product = new ProductServiceImpl().getProductById(productId);
		checkout.setPriceSum(checkout.getPriceSum()-product.getPrice());
		checkoutService.updateOrder(checkout);
		
		checkoutProductDao.removeOrder(checkoutProduct); 
		product.setQuantity(product.getQuantity()+1);	
			new ProductServiceImpl().updateProduct(product); 
		
		
		if(checkSameProductsInList(checkoutProductDao.listOrders(), productId)) {
			List<ShoppingCart> prevProduct = (List<ShoppingCart>) session.getAttribute("prevProduct");
			if(checkoutProductDao.listOrders().isEmpty()) {
				checkoutService.removeOrder(checkout);
				session.removeAttribute("checkout");
				String currentPage = request.getHeader("Referer").substring(
						getRootDomain(request).length());
				System.out.println(currentPage);
				response.sendRedirect(currentPage);
			} else {
				String currentPage = request.getHeader("Referer").substring(
						getRootDomain(request).length());
				System.out.println(currentPage);
				response.sendRedirect(currentPage);
			}
			
			removeProductFromSession(prevProduct, productId, idCheckoutProduct, checkoutId);
			
		} else {
			List<ShoppingCart> prevProduct = (List<ShoppingCart>) session.getAttribute("prevProduct");
			removeProductFromSession(prevProduct, productId, idCheckoutProduct, checkoutId);
			String currentPage = request.getHeader("Referer").substring(
					getRootDomain(request).length());
			System.out.println(currentPage);
			response.sendRedirect(currentPage);
		}
			
		} 
	
	private boolean checkSameProductsInList(List<CheckoutProduct> list,
			Integer productId) {
		int count = 0;
		for (CheckoutProduct chPro : list) {
			if (chPro.getIdProduct() == productId) {
				count++;
			}
		}
		System.out.println("count   " + count);
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private void removeProductFromSession(List<ShoppingCart> prevProduct, Integer productId, Integer idCheckoutProduct, Integer idCheckout) {
		System.out.println("LIST TO REMOVE" + prevProduct);
		for(int i = 0; i < prevProduct.size();) {
			if (prevProduct.get(i).getIdProduct() == productId
					&& prevProduct.get(i).getIdCheckoutProduct() == idCheckoutProduct
					&& prevProduct.get(i).getIdCheckout() == idCheckout) {
				prevProduct.remove(i);
			} else {
				++i;
			}
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
}
