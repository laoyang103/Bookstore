package com.shopping.liao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.liao.dao.UserDao;
import com.shopping.liao.pojo.User;
import com.shopping.util.DBUtils;

public class UserDao4MySqlImpl implements UserDao {

	public User getUserByUid(int userid) {

		Connection conn = DBUtils.getConn();//连接数据库
		User user = null;
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtils.getPstmt(conn,"select * from t_user where id=?");
	    try {
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			user = new User();
			while(rs.next()){
			user.setId(userid);
			user.setUsername(rs.getString(2));//用户名
			user.setRealname(rs.getString(3));
			user.setPassword(rs.getString(4));//密码
			user.setPostcode(rs.getInt(5));//邮编
			user.setPhone(rs.getString(6));//手机号码
			user.setAddress(rs.getString(7));//地址
			user.setRegdate(rs.getTimestamp(8));//注册时间
			user.setGrade(rs.getInt(9));//操作等级
			user.setArea(rs.getString(10));//地区
			//vo
			user.setConsumeSum(this.getConsumSum(userid));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
	    return user;
	}
	
	public void addUser(User user) {
		Connection conn = DBUtils.getConn();//连接数据库
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtils.getPstmt(conn,"insert into t_user values(null,?,?,?,?,?,?,now(),2,?)");
		try {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getRealname());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getPostcode());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getArea());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
	}

	public void deleteUserById(int id) {
		Connection conn = DBUtils.getConn();//连接数据库
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtils.getPstmt(conn,"delete from t_user where id=?");
		try {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public User getUserByUsername(String username) {
		Connection conn = DBUtils.getConn();//连接数据库
		User user = null;
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtils.getPstmt(conn,"select * from t_user where username=?");
	    try {
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				//判断存在用户才new
				user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(username);//用户名
			user.setRealname(rs.getString(3));
			user.setPassword(rs.getString(4));//密码
			user.setPostcode(rs.getInt(5));//邮编
			user.setPhone(rs.getString(6));//手机号码
			user.setAddress(rs.getString(7));//地址
			user.setRegdate(rs.getTimestamp(8));//注册时间
			user.setGrade(rs.getInt(9));//操作等级
			user.setArea(rs.getString(10));//地区

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return user;
	}

	public void alterUserByUsername(User user) {
		Connection conn = DBUtils.getConn();//连接数据库
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtils.getPstmt(conn,"update t_user set realname=?,postcode=?,phone=?,address=?,area=? where id=?");
		try {
			pstmt.setInt(6, user.getId());
			pstmt.setString(1, user.getRealname());
			pstmt.setInt(2, user.getPostcode());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getArea());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 finally {
			DBUtils.close(rs, pstmt, conn);
		}	
		
	}

	public List<User> getAllUsers() {
		Connection conn = DBUtils.getConn();//连接数据库
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtils.getPstmt(conn,"select * from t_user where grade!=0");
		List<User> users = new ArrayList<User>();
		try {
			rs = pstmt.executeQuery();
			User user = null;
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));//用户名
				user.setRealname(rs.getString(3));
				user.setPassword(rs.getString(4));//密码
				user.setPostcode(rs.getInt(5));//邮编
				user.setPhone(rs.getString(6));//手机号码
				user.setAddress(rs.getString(7));//地址
				user.setRegdate(rs.getTimestamp(8));//注册时间
				user.setGrade(rs.getInt(9));//操作等级
				user.setArea(rs.getString(10));//地区
				
				user.setConsumeSum(this.getConsumSum(rs.getInt(1)));
				
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return users;
	}

	public void freezeUserById(int id, int grade) {
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "update t_user set grade = ? where id = ?");
		try {
			
			pstmt.setInt(1, grade);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt);
			DBUtils.close(conn);
		}
		
	}

	public void alterPassword(String password, int id) {
		Connection conn = DBUtils.getConn();//连接数据库
		ResultSet rs = null;
		PreparedStatement pstmt = DBUtils.getPstmt(conn,"update t_user set password=? where id=?");
		try {
			pstmt.setInt(2, id);
			pstmt.setString(1, password);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 finally {
			DBUtils.close(rs, pstmt, conn);
		}	
		
	}

	public double getConsumSum(int userid) {
		// TODO Auto-generated method stub
		double result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select sum(totalmoney) from t_salesorder where userid=?");
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
