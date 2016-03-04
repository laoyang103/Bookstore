package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.CategoryServiceImpl;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class ShowProductsByCategoryidServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int categoryid = Integer.parseInt(request.getParameter("id"));
		
		List<Product> categoryproducts = ProductServiceImpl.getInstance().getProductByCategoryid(categoryid);
		int pid = CategoryServiceImpl.getInstance().getCategoryById(categoryid).getPid();
		String name = CategoryServiceImpl.getInstance().getCategoryById(categoryid).getName();
		String supername = CategoryServiceImpl.getInstance().getCategoryById(pid).getName();
		
		request.setAttribute("supername", supername);
		request.setAttribute("name", name);
		request.setAttribute("categoryproducts", categoryproducts);
		request.getRequestDispatcher("type.jsp").forward(request, response);
		
	}

}
