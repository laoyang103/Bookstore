package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class ShowIndexSpecialProductsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> specialproducts = ProductServiceImpl.getInstance().getProductByIfspecial(1);
		
		List<Product> indexspecialproducts = new ArrayList<Product>();
		int n=0;
		for (Iterator<Product> i = specialproducts.iterator();i.hasNext()&&n<2;n++) {
			Product product = i.next();
			indexspecialproducts.add(product);
		}
		request.setAttribute("indexspecialproducts", indexspecialproducts);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
