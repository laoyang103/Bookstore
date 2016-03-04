package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Category;
import com.shopping.empory.service.impl.CategoryServiceImpl;

public class AddCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		
		Category category = new Category();
		category.setPid(pid);
		category.setName(name);
		category.setDescr(descr);
		
		int result = CategoryServiceImpl.getInstance().addCategory(pid, category);
		PrintWriter out = response.getWriter();
		if(result == 1) {
			out.print("添加成功");
		}else {
			out.print("添加失败");
		}	
		out.flush();
		out.close();
	}

}
