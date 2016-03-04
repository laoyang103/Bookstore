package com.shopping.empory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class GetProductsBySumServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = request.getParameter("url");
		List<Product> products = ProductServiceImpl.getInstance().getProductBySum();
		
		request.setAttribute("products", products);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
