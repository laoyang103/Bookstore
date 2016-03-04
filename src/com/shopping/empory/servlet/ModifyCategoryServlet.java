package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Category;
import com.shopping.empory.service.CategoryService;
import com.shopping.empory.service.impl.CategoryServiceImpl;

public class ModifyCategoryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryService categoryService = CategoryServiceImpl.getInstance();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String desr = request.getParameter("desr");
		PrintWriter out = response.getWriter();
		
		Category category = new Category();
		category.setName(name);
		category.setDescr(desr);
		int result=categoryService.alterCategoryById(id, category);
		if(result == 1) {
			out.print("修改成功！");
		} else {
			out.print("修改失败");
		}
		
		out.flush();
		out.close();
	}

}
