package com.shopping.empory.service.impl;

import java.util.List;

import com.shopping.empory.dao.CommentDao;
import com.shopping.empory.pojo.Comment;
import com.shopping.empory.service.CommentService;
import com.shopping.factory.ObjectFactory;

public class CommentServiceImpl implements CommentService {
	
	private CommentServiceImpl(){}
	private static CommentServiceImpl commentSeviceImpl = new CommentServiceImpl();
	public static CommentService getInstance() {
		return commentSeviceImpl;
	}
	
	private static CommentDao commentDao = (CommentDao)ObjectFactory.getInstance("commentDao");
	
	public List<Comment> getCommentByProductid(int productid) {
		return commentDao.getCommentByProductid(productid);
	}

	public int addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	public int deleteCommentById(int id) {
		return commentDao.deleteCommentById(id);
	}

}
