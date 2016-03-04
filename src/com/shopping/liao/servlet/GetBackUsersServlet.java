package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.User;
import com.shopping.liao.service.impl.UserServiceImpl;

public class GetBackUsersServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> users = UserServiceImpl.getInstance().getAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("manage/MemberManage.jsp").forward(request, response);
	}

}
