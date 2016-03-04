package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.service.impl.NoticeServiceImpl;

public class DeleteNoticeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  int id = Integer.parseInt(request.getParameter("id"));
		  NoticeServiceImpl.getInstance().deleteNoticeById(id);
		  response.sendRedirect("manage/PlacardManage.jsp");
	}

}
