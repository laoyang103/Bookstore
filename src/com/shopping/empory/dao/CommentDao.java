package com.shopping.empory.dao;

import java.util.List;

import com.shopping.empory.pojo.Comment;

public interface CommentDao {
	public List<Comment> getCommentByProductid(int productid);
	public int addComment(Comment comment);
	public int deleteCommentById(int id);
}
