package com.shopping.liao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.shopping.liao.dao.NoticeDao;
import com.shopping.liao.pojo.Notice;
import com.shopping.util.DBUtils;

public class NoticeDao4MySqlImpl implements NoticeDao {

	public Notice getNoticeById(int id) {
		Notice notice = null;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_notice where id=?");
		try {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				notice = new Notice();
				notice.setId(id);
				notice.setTitle(rs.getString(2));
				notice.setContent(rs.getString(3));
				notice.setPdate(rs.getTimestamp(4));
				notice.setEdate(rs.getTimestamp(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return notice;
	}

	public List<Notice> getNotices() {
		List<Notice> notices = new ArrayList<Notice>();
		Notice notice = null;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_notice order by pdate desc");
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				notice = new Notice();
				notice.setId(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setContent(rs.getString(3));
				notice.setPdate(rs.getTimestamp(4));
				notice.setEdate(rs.getTimestamp(5));
				notices.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notices;
	}

	public void deleteNoticeById(int id) {
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "delete from t_notice where id=?");
		try {
			pstmt.setInt(1,id);		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtils.close(null, pstmt, conn);
		}
		
	}

	public void alterNotice(Notice notice) {
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "update t_notice set title=?,content=?,pdate=?,edate=? where id=?");
		try {
			pstmt.setInt(5,notice.getId());
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setTimestamp(3, notice.getPdate());
			pstmt.setTimestamp(4, notice.getEdate());
		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtils.close(null, pstmt, conn);
		}
		
	}

	public void addNotice(Notice notice) {
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "insert into t_notice values(null,?,?,?,?)");
		try {
			
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setTimestamp(3, notice.getPdate());
			pstmt.setTimestamp(4, notice.getEdate());
		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtils.close(null, pstmt, conn);
		}
		
	}

}
