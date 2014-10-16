package com.onlineshop.badion.servlet.registration;

import javax.servlet.http.HttpServletRequest;

public class FullUrl {

	public static String get(HttpServletRequest request) {
		StringBuffer requestURL = request.getRequestURL();
		String queryString = request.getQueryString();
		
		if(queryString == null) {
			return requestURL.toString();
		} else {
			return requestURL.append("?").append(queryString).toString();
		}
	}
}
