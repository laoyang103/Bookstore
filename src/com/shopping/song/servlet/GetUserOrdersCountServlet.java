package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.User;
import com.shopping.song.service.SalesOrderService;
import com.shopping.song.service.impl.SalesOrderServiceImpl;

public class GetUserOrdersCountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//为用户取订单总数
		SalesOrderService salesOrderService = SalesOrderServiceImpl.getInstance();

		PrintWriter out = response.getWriter();
		
		User user = (User)request.getSession().getAttribute("user");
		int userid = user.getId();
		int result = salesOrderService.getSalesOrdersCount4User(userid);
		out.print(result);
		
		out.flush();
		out.close();
	}

}
