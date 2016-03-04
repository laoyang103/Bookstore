package com.shopping.empory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class ShowSpecialProductsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> specialproducts = ProductServiceImpl.getInstance().getProductByIfspecial(1);

		request.setAttribute("specialproducts", specialproducts);

		request.getRequestDispatcher("sale.jsp").forward(request, response);
	}

}
