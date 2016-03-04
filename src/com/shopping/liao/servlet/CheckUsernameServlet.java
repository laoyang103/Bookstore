package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.User;
import com.shopping.liao.service.UserService;
import com.shopping.liao.service.impl.UserServiceImpl;

public class CheckUsernameServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = UserServiceImpl.getInstance();
		//拿到out输出
		PrintWriter out = response.getWriter();
		//接受参数
		String inputUsername = request.getParameter("username");
		User user = null;
		user = userService.getUserByUsername(inputUsername);
		if (inputUsername != "") {
			if (user == null) {
				out.print("<font color='green'>用户名不存在，可以注册</font>");
			} else {
				// 通过out.print(String)给回调函数传参
				out.print("<font color='red'>用户名已存在!</font>");
			}
		}
		out.flush();
		out.close();
	}
	

}
