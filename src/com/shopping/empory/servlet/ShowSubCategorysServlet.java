package com.shopping.empory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Category;
import com.shopping.empory.service.impl.CategoryServiceImpl;

public class ShowSubCategorysServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		List<Category> categorys = CategoryServiceImpl.getInstance().getChildenByPid(pid);
		String categoryname = CategoryServiceImpl.getInstance().getCategoryById(pid).getName();
		
		request.setAttribute("pid", pid);
		request.setAttribute("categorys", categorys);
		request.setAttribute("categoryname", categoryname);
		
		request.getRequestDispatcher("./manage/subType.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
