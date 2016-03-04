package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.User;
import com.shopping.liao.service.impl.UserServiceImpl;

public class AlterPasswordServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("11111111");
		String password =request.getParameter("password");
		User user = (User)request.getSession().getAttribute("user");
		int id = user.getId();
		PrintWriter out = response.getWriter();
		try{
			UserServiceImpl.getInstance().alterPassword(password, id);
			out.print("密码修改成功,需要重新登录！");
			request.getSession().invalidate();
		}
		catch(Exception e){
			out.print("密码修改失败！");
		}
		out.flush();
		out.close();
	}

}
