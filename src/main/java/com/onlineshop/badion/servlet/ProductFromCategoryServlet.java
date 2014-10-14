package com.onlineshop.badion.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.badion.dao.CheckoutProductDaoImpl;
import com.onlineshop.badion.model.Checkout;
import com.onlineshop.badion.model.CheckoutProduct;
import com.onlineshop.badion.model.Customer;
import com.onlineshop.badion.model.Groupp;
import com.onlineshop.badion.model.Product;
import com.onlineshop.badion.model.ShoppingCart;
import com.onlineshop.badion.service.CheckoutServiceImpl;
import com.onlineshop.badion.service.GroupServiceImpl;
import com.onlineshop.badion.service.ProductServiceImpl;

public class ProductFromCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String message = "add";
    
    private CheckoutProductDaoImpl checkoutProductDaoImpl = new CheckoutProductDaoImpl(); // many products in 1 checkout
    private CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();	// 1 checkout
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String laptops = "Laptops";
		String eBooks = "eBooks";
		String tablets = "Tablets";
		String phones = "Phones";
 		String nameOfProduct = request.getParameter("name");
 		
 		if(request.getParameter("productId") == null) {
 		
 		List<Product> productList = new ArrayList<Product>();
 		Groupp groupp = new Groupp();
 			
		if(nameOfProduct == null) {
			request.getRequestDispatcher("home").forward(request, response);
			request.setAttribute("msg", new Message("danger", "Warning ", "Wrong category"));
		} 
		else if(isProduct(laptops, nameOfProduct, request, groupp, productList))
			request.getRequestDispatcher("WEB-INF/pages/products/laptop.jsp").forward(request, response);
		else if(isProduct(phones, nameOfProduct, request, groupp, productList))
			request.getRequestDispatcher("WEB-INF/pages/products/phone.jsp").forward(request, response);
		else if(isProduct(eBooks, nameOfProduct, request, groupp, productList))
			request.getRequestDispatcher("WEB-INF/pages/products/eBook.jsp").forward(request, response);
		else if(isProduct(tablets, nameOfProduct, request, groupp, productList))
			request.getRequestDispatcher("WEB-INF/pages/products/tablet.jsp").forward(request, response);
		} 
 		
 		else {
 			HttpSession session = request.getSession(true);
 			
 			//****************************
 			List<ShoppingCart> shoppingList = (List<ShoppingCart>) session.getAttribute("prevProduct");
 			if(session.getAttribute("prevProduct") == null || shoppingList.isEmpty()) {
 				Product product = new ProductServiceImpl().getProductById(Integer.parseInt(request.getParameter("productId")));
 				ShoppingCart shoppingCart = new ShoppingCart();
 				if(!isProductQuantityEmpty(product)) {
 					request.setAttribute("msg", new Message("danger", "Error ", "Product is not avaiable"));
					request.getRequestDispatcher("mainCategories").forward(request, response);
 				} else {
 					product.setQuantity(product.getQuantity()-1);	
 					new ProductServiceImpl().updateProduct(product); 	//update product
 					
 					Checkout checkout = new Checkout();
 					CheckoutProduct checkoutProduct = new CheckoutProduct();
 					
 					Customer customer = (Customer) session.getAttribute("customer");
 					shoppingCart.setIdCustomer(customer.getId());
 					//ADD CHECKOUT
 					//*****************************************
 					checkout.setDate(new Date());
 					checkout.setIdCustomer(customer.getId());
 					checkout.setOrderStatus("processed");
 					checkout.setPriceSum(product.getPrice());
 					checkoutServiceImpl.addOrder(checkout);
 					
 					shoppingCart.setIdCheckout(checkout.getId());
 					//*****************************************
 					
 					//ADD CHECKOUTPRODUCT
 					//***********************************************
 					checkoutProduct.setIdCheckout(checkout.getId());
 					checkoutProduct.setIdProduct(product.getId());
 					checkoutProductDaoImpl.addOrder(checkoutProduct);
 					shoppingCart.setIdCheckoutProduct(checkoutProduct.getId());
 					System.out.println("When add checkout product" + checkoutProduct);
 					System.out.println("When add from db chProduct" + checkoutProductDaoImpl.listOrders());
 					//************************************************
 					
 					List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
 					
 					shoppingCart.setIdProduct(product.getId());
 	 				shoppingCart.setName(product.getName());
 	 				shoppingCart.setDescription(product.getDescription());
 	 				shoppingCart.setPrice(product.getPrice());
 	 				shoppingCart.setQuantity(product.getQuantity());
 	 				shoppingCart.setIdGroup(product.getIdGroup());
 					shoppingCartList.add(shoppingCart);
 					
 					System.out.println("product if prevProduct == null" + shoppingCartList);
 					session.setAttribute("prevProduct", shoppingCartList);
 					session.setAttribute("checkout", checkout);
 					
 					response.sendRedirect(request.getHeader("Referer").substring(	//get current page
 							getRootDomain(request).length()));
 				}
 				
 			} else {		
 				List<ShoppingCart> shoppingCartList = (List<ShoppingCart>) session.getAttribute("prevProduct"); //get this list
 				Product product = new ProductServiceImpl().getProductById(Integer.parseInt(request.getParameter("productId")));
 				product.setQuantity(product.getQuantity()-1);	
				new ProductServiceImpl().updateProduct(product);
 				ShoppingCart shoppingCart = new ShoppingCart();
 					shoppingCart.setIdProduct(product.getId());
	 				shoppingCart.setName(product.getName());
	 				shoppingCart.setDescription(product.getDescription());
	 				shoppingCart.setPrice(product.getPrice());
	 				shoppingCart.setQuantity(product.getQuantity());
	 				shoppingCart.setIdGroup(product.getIdGroup());
 				if(!isProductQuantityEmpty(product)) {
 					request.setAttribute("msg", new Message("danger", "Error ", "Product is not avaiable"));
					request.getRequestDispatcher("mainCategories").forward(request, response);
 				} else {
 					
 					Checkout checkout = (Checkout) session.getAttribute("checkout");
 					System.out.println("Checkout if prevProduct != null" + checkout);
 					
 					//Add in checkout_product
 					//******************************************************
 					CheckoutProduct checkoutProduct = new CheckoutProduct();
 					checkoutProduct.setIdCheckout(checkout.getId());
 					checkoutProduct.setIdProduct(product.getId());
 					checkoutProductDaoImpl.addOrder(checkoutProduct);
 					session.setAttribute("idCheckoutProduct", checkoutProduct.getId());
 					//******************************************************
 					
 					//Add new product to list
 					//****************************************************************
 					
 					shoppingCart.setIdCheckout(checkout.getId());
 					shoppingCart.setIdCheckoutProduct(checkoutProduct.getId());
 					/*
 					*/
 					
 					shoppingCartList.add(shoppingCart);
 					System.out.println("product if prevProduct != null" + shoppingCartList);
 					//****************************************************************
 					
 					//Calculate sum
 					//******************************
 					Double result = 0.0;
 					for(ShoppingCart p : shoppingCartList) {
 						result += p.getPrice();
 					}
 					shoppingCart.setTotalPrice(result);
 					checkout.setPriceSum(result);
 					//******************************
 					checkoutServiceImpl.updateOrder(checkout);
 					
 					response.sendRedirect(request.getHeader("Referer").substring(
 							getRootDomain(request).length()));
 				}
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
	
	public boolean isProduct(String productName, String nameFromRequest,
			HttpServletRequest request, Groupp groupp, List<Product> productList) {
		if (nameFromRequest != null && nameFromRequest.equals(productName)) {
			groupp = new GroupServiceImpl().getGroupByName(productName);
			productList = new ProductServiceImpl().getProductByIdGroup(groupp
					.getId());
			request.setAttribute("productList", productList);
			return true;
		}
		return false;
	}
	
	public Boolean isProductQuantityEmpty(Product product) {
			if(product.getQuantity() <= 0) {
				return false;
			} else {
			return true;
			}
		}
	}
