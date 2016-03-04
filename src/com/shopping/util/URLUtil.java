package com.shopping.util;

import javax.servlet.http.HttpServletRequest;

public class URLUtil {
	public static String getReqURL(HttpServletRequest request) {
		int cutLength = request.getRequestURL().length()-request.getServletPath().length();
		String reqURL = request.getHeader("Referer").substring(cutLength);
		return reqURL;
	}
}
