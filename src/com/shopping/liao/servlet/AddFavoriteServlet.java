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

public class AddFavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException,RuntimeException {
		
		FavoriteService favoriteService = FavoriteServiceImpl.getInstance();

		int productid = Integer.parseInt(request.getParameter("productid"));
		PrintWriter out = response.getWriter();
		
		User user = (User)request.getSession().getAttribute("user");
		if(user == null) {
			out.print("你是不是还没登陆呢？");
			return;
		}
		List<Product> products = favoriteService.getFavoriteByUserid(user.getId());
		for (Product product : products) {
			if(product.getId() == productid) {
				out.print("这个商品你之前已经收藏过了哦~~");
				return;
			}
		}
		
		
		int result = favoriteService.addFavorite(productid, user.getId());
		if(result == 1) {
			out.print("添加收藏成功");
		} else {
			out.print("添加收藏失败");
		}
		
		out.flush();
		out.close();
	}

}
