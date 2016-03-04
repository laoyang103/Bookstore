package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.Notice;
import com.shopping.liao.service.impl.NoticeServiceImpl;
import com.shopping.util.URLUtil;

public class GetNoticesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getParameter("url");
		List<Notice> notices = NoticeServiceImpl.getInstance().getNotices();
		if(notices.size() == 0) {
			request.setAttribute("isNull", 1);
		}
		request.setAttribute("notices", notices);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
