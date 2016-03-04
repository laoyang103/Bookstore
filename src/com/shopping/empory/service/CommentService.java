package com.shopping.empory.service;

import java.util.List;

import com.shopping.empory.pojo.Comment;

public interface CommentService {
	public List<Comment> getCommentByProductid(int productid);
	public int addComment(Comment comment);
	public int deleteCommentById(int id);
}
