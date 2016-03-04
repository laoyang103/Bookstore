package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.Ad;
import com.shopping.liao.service.impl.AdServiceImpl;
import com.shopping.util.URLUtil;

public class GetSourceServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//字符的filter我已经在项目里面家过了，不用加了
		//response.setCharacterEncoding("UTF-8");
		//直接拿所有的广告
		String url = request.getParameter("url");
		List<Ad> ads = AdServiceImpl.getInstance().getAllAds();
		request.setAttribute("ads", ads);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
