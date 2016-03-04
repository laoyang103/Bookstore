package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class DeleteProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int productid = Integer.parseInt(request.getParameter("productid"));
		ProductService productService = ProductServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		
		int result = productService.deleteProductById(productid);
		if(result == 1) {
			out.print("删除成功");
		}else {
			out.print("删除失败");
		}
		
		out.flush();
		out.close();
	}

}
