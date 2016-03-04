package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.song.service.SalesOrderService;
import com.shopping.song.service.impl.SalesOrderServiceImpl;

public class DeleteOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SalesOrderService salesOrderService = SalesOrderServiceImpl.getInstance();

		PrintWriter out = response.getWriter();

		String orderid = request.getParameter("orderid");
		int result = salesOrderService.deleteSalesOrderById(orderid);
		if(result == 1){
			out.print("订单删除成功");
		}else{
			out.print("订单删除失败");
		}
		
		out.flush();
		out.close();
	}

}
