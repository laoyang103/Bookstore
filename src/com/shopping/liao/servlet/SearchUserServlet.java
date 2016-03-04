package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.exception.UsernameNotFoundException;
import com.shopping.liao.pojo.User;
import com.shopping.liao.service.UserService;
import com.shopping.liao.service.impl.UserServiceImpl;

public class SearchUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserService userService = UserServiceImpl.getInstance();
		
		String username = request.getParameter("mname");

		User user = userService.getUserByUsername(username);

		request.setAttribute("user", user);
		request.getRequestDispatcher("./manage/member_search.jsp").forward(request, response);

	}

}
