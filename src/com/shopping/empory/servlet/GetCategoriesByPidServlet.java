package com.shopping.empory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Category;
import com.shopping.empory.service.CategoryService;
import com.shopping.empory.service.impl.CategoryServiceImpl;

public class GetCategoriesByPidServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryService categoryService  = CategoryServiceImpl.getInstance();

		int pid = Integer.parseInt(request.getParameter("pid"));
		PrintWriter out = response.getWriter();
		
		StringBuffer jsonString = new StringBuffer("[");
		List<Category> categories = categoryService.getChildenByPid(pid);
		for (Iterator<Category> i = categories.iterator();i.hasNext();) {
			Category category = i.next();
			int id = category.getId();
			String name = category.getName();
			jsonString.append("{\"id\":"+id+",\"name\":\""+name+"\"},");
		}
		jsonString.deleteCharAt(jsonString.length()-1);
		jsonString.append("]");
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

}
