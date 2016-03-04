package com.shopping.empory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Comment;
import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.CategoryServiceImpl;
import com.shopping.empory.service.impl.CommentServiceImpl;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class ShowProductDetail4AdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Product product = ProductServiceImpl.getInstance().getProductById(id);
		String categoryname = CategoryServiceImpl.getInstance().getCategoryById(product.getCategoryid()).getName();
		
		request.setAttribute("product", product);
		request.setAttribute("categoryname", categoryname);
		
		request.getRequestDispatcher("manage/goods_detail.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
