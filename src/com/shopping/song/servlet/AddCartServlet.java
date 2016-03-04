package com.shopping.song.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.service.ProductService;
import com.shopping.empory.service.impl.ProductServiceImpl;


public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductService productService = ProductServiceImpl.getInstance();
		PrintWriter out = response.getWriter();

		String productId = request.getParameter("productId");
		int amount = 1;
		
		try {
			Cookie[] cookies = request.getCookies();
			for(int i=1;i<cookies.length;i++) {
				if(cookies[i].getName().equals(productId)){
					amount += Integer.parseInt(cookies[i].getValue());
				}
			}
			Cookie cookie = new Cookie(productId, amount+"");
			response.addCookie(cookie);
			String productName = productService.getProductById(Integer.parseInt(productId)).getName();
			out.print("1个<font color=yellow size=6>"+productName+"</font>成功加入，现在已有<font color=red size=5>"+amount+"</font>个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("加入购物车失败！");
		}
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
