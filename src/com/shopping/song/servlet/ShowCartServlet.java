package com.shopping.song.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.ProductServiceImpl;

import com.shopping.empory.pojo.Product;


public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductService productService = ProductServiceImpl.getInstance();
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length>1) {
			StringBuffer jsonString = new StringBuffer("[");
			for(int i=1;i<cookies.length;i++) {
				Product product =  productService.getProductById(Integer.parseInt(cookies[i].getName()));
				
				int id = product.getId();
				String productName = product.getName();
				double nomalPrice = product.getNormalprice();
				double memberPrice = product.getMemberprice();
				int amount = Integer.parseInt(cookies[i].getValue());
				double memberItemTotalMoney = memberPrice * amount;
				double nomalItemTotalMoney = nomalPrice * amount;
				jsonString.append("{\"id\":"+id+",\"productName\":\""+productName+"\",\"nomalPrice\":"+nomalPrice+",\"memberPrice\":"+memberPrice+",\"amount\":"+amount+",\"memberItemTotalMoney\":"+memberItemTotalMoney+",\"nomalItemTotalMoney\":"+nomalItemTotalMoney+"},");
			}
			jsonString.deleteCharAt(jsonString.length()-1);
			jsonString.append("]");
			out.print(jsonString);
		}
		else {
			out.print("[]");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
