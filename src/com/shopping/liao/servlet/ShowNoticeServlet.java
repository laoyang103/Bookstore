package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.Notice;
import com.shopping.liao.service.impl.NoticeServiceImpl;

public class ShowNoticeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Notice notice = NoticeServiceImpl.getInstance().getNoticeById(id);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("./manage/placard_modify.jsp").forward(request, response);
		
	}

}
