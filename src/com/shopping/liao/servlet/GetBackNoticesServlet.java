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
import com.shopping.liao.service.impl.NoticeServiceImpl;

public class GetBackNoticesServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Notice> notices = new ArrayList<Notice>();
		notices = NoticeServiceImpl.getInstance().getNotices();
		if(notices.size() == 0) {
			request.setAttribute("isNull", 1);
		}
		request.setAttribute("notices", notices);
		request.getRequestDispatcher("manage/PlacardManage.jsp").forward(request, response);	
	}

}
