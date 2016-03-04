package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.song.service.SalesOrderService;
import com.shopping.song.service.impl.SalesOrderServiceImpl;

public class GetSearchOrderCountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//拿到相应订单状态的订单数（管理员）
		SalesOrderService salesOrderService = SalesOrderServiceImpl.getInstance();

		PrintWriter out = response.getWriter();
		
		int status = Integer.parseInt(request.getParameter("status"));
		int result = salesOrderService.getSearchOrderCount4Admin(status);
		out.print(result);
		
		out.flush();
		out.close();
	}

}
