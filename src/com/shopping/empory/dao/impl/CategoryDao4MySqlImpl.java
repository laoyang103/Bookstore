package com.shopping.empory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.empory.dao.CategoryDao;
import com.shopping.empory.pojo.Category;
import com.shopping.util.DBUtils;

public class CategoryDao4MySqlImpl implements CategoryDao {

	public List<Category> getCategory() {
		List<Category> categorys = new ArrayList<Category>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_category");
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setPid(rs.getInt(2));
				category.setName(rs.getString(3));
				category.setDescr(rs.getString(4));
				category.setCno(rs.getInt(5));
				category.setGrade(rs.getInt(6));
				
				categorys.add(category);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return categorys;
	}

	public List<Category> getChildenByPid(int pid) {
		List<Category> categorys = new ArrayList<Category>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_category where pid = ?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setPid(rs.getInt(2));
				category.setName(rs.getString(3));
				category.setDescr(rs.getString(4));
				category.setCno(rs.getInt(5));
				category.setGrade(rs.getInt(6));
				
				categorys.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return categorys;
	}

	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select * from t_category where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				category = new Category();
				category.setPid(rs.getInt(2));
				category.setName(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return category;
	}
	
	public int deleteCategoryById(int id) {
		int n = 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "delete from t_category where id = ?");
		try {
			pstmt.setInt(1, id);
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}
		return n;
	}

	public int addCategory(int pid, Category category) {
		int n= 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "insert into t_category(id,pid,name,descr) values(null,?,?,?)");
		try {
			pstmt.setInt(1, pid);
			pstmt.setString(2, category.getName());
			pstmt.setString(3, category.getDescr());
			
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}	
		return n;
	}

	public int alterCategoryById(int id, Category category) {
		int n = 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "update t_category set name = ?,descr = ? where id = ?");
		try {
			pstmt.setString(1, category.getName());
			pstmt.setString(2, category.getDescr());
			pstmt.setInt(3, id);
			
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
