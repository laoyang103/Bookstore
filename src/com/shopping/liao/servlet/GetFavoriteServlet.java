package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Product;
import com.shopping.liao.pojo.User;
import com.shopping.liao.service.FavoriteService;
import com.shopping.liao.service.impl.FavoriteServiceImpl;

public class GetFavoriteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user =  (User)request.getSession().getAttribute("user");
		int userid = user.getId();
		
		List<Product> favorites = FavoriteServiceImpl.getInstance().getFavoriteByUserid(userid);
		request.setAttribute("favorites", favorites);
		request.getRequestDispatcher("favorite.jsp").forward(request, response);
	}

}
