package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.Notice;
import com.shopping.liao.pojo.User;
import com.shopping.liao.service.impl.NoticeServiceImpl;
import com.shopping.liao.service.impl.UserServiceImpl;

public class GetBackUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user = UserServiceImpl.getInstance().getUserByUid(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/manage/member_detail.jsp").forward(request, response);
	}

}
