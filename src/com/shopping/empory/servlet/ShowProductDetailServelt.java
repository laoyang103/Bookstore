package com.shopping.empory.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Comment;
import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.CommentServiceImpl;
import com.shopping.empory.service.impl.ProductServiceImpl;

public class ShowProductDetailServelt extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		Product product = ProductServiceImpl.getInstance().getProductById(id);
		List<Comment> comments= CommentServiceImpl.getInstance().getCommentByProductid(id);
		
		request.setAttribute("product", product);
		request.setAttribute("comments", comments);
		
		request.getRequestDispatcher("goods_detail.jsp").forward(request, response);
	}

}
