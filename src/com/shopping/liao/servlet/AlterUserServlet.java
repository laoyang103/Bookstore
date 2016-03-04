package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.User;
import com.shopping.liao.service.impl.UserServiceImpl;

public class AlterUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		String username =request.getParameter("username");
		String realname =request.getParameter("realname");
		String location =request.getParameter("location");
		String address = request.getParameter("address");
		int postcode = Integer.parseInt(request.getParameter("postcode"));
		String phone = request.getParameter("telephone");
		user.setId( UserServiceImpl.getInstance().getUserByUsername(username).getId());
		user.setUsername(username);
		user.setRealname(realname);
		user.setAddress(address);
		user.setPostcode(postcode);
		user.setPhone(phone);
		user.setArea(location);
		PrintWriter out = response.getWriter();
		

		try{
			UserServiceImpl.getInstance().alterUserByUsername(user);
			out.print("修改成功！");
			request.getSession().setAttribute("user", user);
		
		}
		catch (Exception e){
			out.print("修改失败！");
		}
		out.flush();
		out.close();
	}

}
