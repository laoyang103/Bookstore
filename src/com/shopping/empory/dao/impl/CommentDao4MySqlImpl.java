package com.shopping.empory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.empory.dao.CommentDao;
import com.shopping.empory.pojo.Comment;
import com.shopping.liao.dao.impl.UserDao4MySqlImpl;
import com.shopping.util.DBUtils;

public class CommentDao4MySqlImpl implements CommentDao {

	public List<Comment> getCommentByProductid(int productid) {
		List<Comment> comments = new ArrayList<Comment>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_comment where productid =?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, productid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setContent(rs.getString(2));
				comment.setCdate(rs.getDate(3));
				comment.setUserid(rs.getInt(4));
				comment.setProductid(rs.getInt(5));
				//vo
				comment.setUserName(new UserDao4MySqlImpl().getUserByUid(rs.getInt(4)).getUsername());
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return comments;
	}
	
	public int addComment(Comment comment) {
		int n= 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "insert into t_comment values(null,?,now(),?,?)");
		try {
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getUserid());
			pstmt.setInt(3,comment.getProductid());
			
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}	
		return n;
	}

	public int deleteCommentById(int id) {
		int n = 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "delete from t_comment where id = ?");
		try {
			pstmt.setInt(4, id);
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}
		return n;
	}

}
