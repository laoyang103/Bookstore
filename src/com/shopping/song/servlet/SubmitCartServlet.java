package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.ProductServiceImpl;

import com.shopping.liao.pojo.User;
import com.shopping.song.service.SalesItemService;
import com.shopping.song.service.SalesOrderService;
import com.shopping.song.service.impl.SalesItemServiceImpl;
import com.shopping.song.service.impl.SalesOrderServiceImpl;
import com.shopping.util.NameUtil;

public class SubmitCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SalesOrderService salesOrderService = SalesOrderServiceImpl.getInstance();
		SalesItemService salesItemService = SalesItemServiceImpl.getInstance();
		ProductService productService = ProductServiceImpl.getInstance();
		
		PrintWriter out = response.getWriter();
		
		String msg = "订单提交失败";
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		String orderid = NameUtil.createSalesOrderId();
		int userid = user.getId();
		double totalmoney = 0;
		String recievename = request.getParameter("recievename");
		String address = request.getParameter("address");
		int postcode = Integer.parseInt(request.getParameter("postcode"));
		String phone = request.getParameter("phone");
		int paymethod = Integer.parseInt(request.getParameter("paymethod"));
		
		int recievemethod = Integer.parseInt(request.getParameter("recievemethod"));
		int timedemand = Integer.parseInt(request.getParameter("timedemand"));
		int status = 1;
		String remark = request.getParameter("remark");
		
		int result = salesOrderService.addSalesOrder(orderid, userid, totalmoney, recievename, address, postcode, phone, paymethod, recievemethod, timedemand,status, remark);
		
		if(result == 1) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length>1) {
				for(int i=1;i<cookies.length;i++) {
					int productid = Integer.parseInt(cookies[i].getName());
					//得到商品单价
					double unitprice = productService.getProductById(productid).getMemberprice();
					int pcount = Integer.parseInt(cookies[i].getValue());
					//计算每样商品的小计，总价累加
					double itemTotalMoney = unitprice * pcount;
					totalmoney += itemTotalMoney;
					//添加一个订单项
					salesItemService.addSalesItem(productid, unitprice, pcount, orderid);
				}
				//更新总价格
				salesOrderService.alterSalesOrder(orderid, totalmoney);
				//修改返回信息
				msg = "订单提交成功";
			}
		}
		out.print(msg);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
