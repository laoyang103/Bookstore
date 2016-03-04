package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Category;
import com.shopping.empory.service.CategoryService;
import com.shopping.empory.service.impl.CategoryServiceImpl;

public class GetParentCategoriesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		CategoryService categoryService = CategoryServiceImpl.getInstance();
		List<Category> categories = categoryService.getChildenByPid(0);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
