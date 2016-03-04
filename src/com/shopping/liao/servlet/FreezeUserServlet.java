package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shopping.liao.service.impl.UserServiceImpl;


public class FreezeUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		com.shopping.liao.pojo.User user = UserServiceImpl.getInstance().getUserByUid(userId);
		if(user.getGrade()!=1){
			UserServiceImpl.getInstance().freezeUserById(userId,1);
		}else {
			UserServiceImpl.getInstance().freezeUserById(userId,2);
		}
		response.sendRedirect("./manage/MemberManage.jsp");
	}

}
