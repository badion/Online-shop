package com.onlineshop.badion.errorpage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ErrorPage extends HttpServletResponseWrapper {

	 public ErrorPage(HttpServletResponse httpServletResponse) {
	        super(httpServletResponse);
	    }

	    public void sendError(int errorCode) throws IOException {
	        if (errorCode == HttpServletResponse.SC_NOT_FOUND){
	            throw new PageNotFoundException();
	        }
	        
	        super.sendError(errorCode);
	    }

 
}

	