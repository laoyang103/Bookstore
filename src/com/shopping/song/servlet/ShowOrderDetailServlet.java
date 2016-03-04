package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.song.pojo.SalesOrder;
import com.shopping.song.service.SalesOrderService;
import com.shopping.song.service.impl.SalesOrderServiceImpl;

public class ShowOrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SalesOrderService salesOrderService = SalesOrderServiceImpl.getInstance();
		
		String orderid = request.getParameter("orderid");
		String flag = request.getParameter("flag");
		String path = null;
		SalesOrder salesOrder = salesOrderService.getSalesOrderById(orderid);
		request.setAttribute("salesOrder", salesOrder);
		
		if (flag.equals("admin")) {
			path = "./manage/order_detail.jsp";
		} else {
			path = "order_detail.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
