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

public class GetAllOrdersCountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SalesOrderService salesOrderService = SalesOrderServiceImpl.getInstance();

		PrintWriter out = response.getWriter();
		
		int result = salesOrderService.getAllOrdersCount4Admin();
		out.print(result);
		
		out.flush();
		out.close();
	}

}
