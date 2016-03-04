package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.empory.pojo.Comment;
import com.shopping.empory.service.CommentService;
import com.shopping.empory.service.impl.CommentServiceImpl;
import com.shopping.liao.pojo.User;

public class SubmitCommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CommentService commentService = CommentServiceImpl.getInstance();
		String content = request.getParameter("content");
		int productid = Integer.parseInt(request.getParameter("productid"));
		User user = (User)request.getSession().getAttribute("user");
		int userid = user.getId();

		PrintWriter out = response.getWriter();
		
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setUserid(userid);
		comment.setProductid(productid);
		int result = commentService.addComment(comment);
		if(result == 1) {
			out.print("添加成功");
		} else {
			out.print("添加失败");
		}
		
		out.flush();
		out.close();
	}

}
