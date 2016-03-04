package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class ShowAllProductsServelt extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductService productService = ProductServiceImpl.getInstance();
		List<Product> products = productService.getAllProduct();
		request.setAttribute("products", products);
		request.getRequestDispatcher("manage/GoodsManage.jsp").forward(request, response);
	}

}
