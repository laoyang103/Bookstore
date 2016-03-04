package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class CheckProductIfExistsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductService productService = ProductServiceImpl.getInstance();

		int productId = Integer.parseInt(request.getParameter("productId"));
		PrintWriter out = response.getWriter();
		
		int ncount = productService.getProductById(productId).getNcount();
		if (ncount>0) {
			out.print("有货");
		} else {
			out.print("无货");
		}
		
		out.flush();
		out.close();
	}

}
