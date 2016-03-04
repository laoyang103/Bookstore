package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.exception.PasswordErrorException;
import com.shopping.liao.exception.UsernameNotFoundException;
import com.shopping.liao.pojo.User;
import com.shopping.liao.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		User user = null;
		try{
			user = UserServiceImpl.getInstance().Login(username, password);
			if(user.getGrade()==1){
				out.print("您的帐号已被冻结！");
			}
			else{
			out.print("登录成功！");
			request.getSession().setAttribute("user", user);
			}
			}
		catch(UsernameNotFoundException e){
			out.print("用户"+username+"找不到！");
			
		}
		catch(PasswordErrorException e){
			out.print("密码错误！");
		}
				
		out.flush();
		out.close();
		
	}

}
