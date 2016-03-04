package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.User;
import com.shopping.liao.service.impl.UserServiceImpl;

public class addUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		User user = new User();
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String realname =request.getParameter("realname");
		String location =request.getParameter("location");
		String address =request.getParameter("address");
		int postcode = Integer.parseInt(request.getParameter("postcode"));
		String phone = request.getParameter("telephone");
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setAddress(address);
		user.setPostcode(postcode);
		user.setPhone(phone);
		user.setArea(location);
		PrintWriter out = response.getWriter();
		try{
			UserServiceImpl.getInstance().addUser(user);
			request.getSession().setAttribute("user", user);
			out.print("恭喜你，注册成功！现在可以购物了！");
		}
		catch (Exception e){
			out.print("系统忙，注册失败！");
		}
		out.flush();
		out.close();
		
	}

}
