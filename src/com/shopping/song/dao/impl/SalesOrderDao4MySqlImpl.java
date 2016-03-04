package com.shopping.song.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.factory.ObjectFactory;
import com.shopping.liao.dao.UserDao;
import com.shopping.song.dao.SalesItemDao;
import com.shopping.song.dao.SalesOrderDao;
import com.shopping.song.pojo.SalesOrder;
import com.shopping.util.DBUtils;

public class SalesOrderDao4MySqlImpl implements SalesOrderDao {
	
	private static SalesItemDao salesItemDao = (SalesItemDao)ObjectFactory.getInstance("salesItemDao");
	private static UserDao userDao = (UserDao)ObjectFactory.getInstance("userDao");

	public List<SalesOrder> getSalesOrdersByUid(int userid,int beginIndex,int singlePageCount) {
		List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select * from t_salesorder where userid=? ORDER BY pdate DESC limit ?,?");
			pstmt.setInt(1, userid);
			pstmt.setInt(2, beginIndex);
			pstmt.setInt(3, singlePageCount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SalesOrder salesOrder = new SalesOrder();
				salesOrder.setId(rs.getString(1));
				salesOrder.setUser(userDao.getUserByUid(userid));
				salesOrder.setTotalmoney(rs.getDouble(3));
				salesOrder.setPdate(rs.getTimestamp(4));
				salesOrder.setRecievename(rs.getString(5));
				salesOrder.setAddress(rs.getString(6));
				salesOrder.setPaymethod(rs.getInt(7));
				salesOrder.setRecievemethod(rs.getInt(8));
				salesOrder.setTimedemand(rs.getInt(9));
				salesOrder.setStatus(rs.getInt(10));
				salesOrder.setRemark(rs.getString(11));
				salesOrder.setSalesItems(salesItemDao.getSalesItemsBySalesOrderId(rs.getString(1)));
				
				salesOrders.add(salesOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return salesOrders;
	}

	public int deleteSalesOrderById(String id) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "delete from t_salesorder where id=?");
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
		return result;
	}

	public SalesOrder getSalesOrderById(String id) {
		// TODO Auto-generated method stub
		SalesOrder salesOrder = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select * from t_salesorder where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				salesOrder = new SalesOrder();
				salesOrder.setId(rs.getString(1));
				//salesOrder.setUser(user)
				salesOrder.setUser(userDao.getUserByUid(rs.getInt(2)));
				salesOrder.setTotalmoney(rs.getDouble(3));
				salesOrder.setPdate(rs.getTimestamp(4));
				salesOrder.setRecievename(rs.getString(5));
				salesOrder.setAddress(rs.getString(6));
				salesOrder.setPaymethod(rs.getInt(7));
				salesOrder.setRecievemethod(rs.getInt(8));
				salesOrder.setTimedemand(rs.getInt(9));
				salesOrder.setStatus(rs.getInt(10));
				salesOrder.setRemark(rs.getString(11));
				salesOrder.setPostcode(rs.getInt(12));
				salesOrder.setPhone(rs.getString(13));
				salesOrder.setSalesItems(salesItemDao.getSalesItemsBySalesOrderId(id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return salesOrder;
	}

	public int addSalesOrder(SalesOrder salesOrder) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "insert into t_salesorder values(?,?,?,now(),?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, salesOrder.getId());
			pstmt.setInt(2, salesOrder.getUser().getId());
			pstmt.setDouble(3, salesOrder.getTotalmoney());
			pstmt.setString(4, salesOrder.getRecievename());
			pstmt.setString(5, salesOrder.getAddress());
			pstmt.setInt(6, salesOrder.getPaymethod());
			pstmt.setInt(7, salesOrder.getRecievemethod());
			pstmt.setInt(8, salesOrder.getTimedemand());
			pstmt.setInt(9, salesOrder.getStatus());
			pstmt.setString(10, salesOrder.getRemark());
			pstmt.setInt(11, salesOrder.getPostcode());
			pstmt.setString(12, salesOrder.getPhone());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt, conn);
		}
		return result;
	}

	public int alterSalesOrder(String id, double totalmoney) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "update t_salesorder set totalmoney=? where id=?");
			pstmt.setDouble(1, totalmoney);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<SalesOrder> getAllSalesOrders(int beginIndex,int singlePageCount) {
		List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select * from t_salesorder ORDER BY pdate DESC limit ?,?");
			pstmt.setInt(1, beginIndex);
			pstmt.setInt(2, singlePageCount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SalesOrder salesOrder = new SalesOrder();
				salesOrder.setId(rs.getString(1));
				salesOrder.setUser(userDao.getUserByUid(rs.getInt(2)));
				salesOrder.setTotalmoney(rs.getDouble(3));
				salesOrder.setPdate(rs.getTimestamp(4));
				salesOrder.setRecievename(rs.getString(5));
				salesOrder.setAddress(rs.getString(6));
				salesOrder.setPaymethod(rs.getInt(7));
				salesOrder.setRecievemethod(rs.getInt(8));
				salesOrder.setTimedemand(rs.getInt(9));
				salesOrder.setStatus(rs.getInt(10));
				salesOrder.setRemark(rs.getString(11));
				salesOrder.setSalesItems(salesItemDao.getSalesItemsBySalesOrderId(rs.getString(1)));
				
				salesOrders.add(salesOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return salesOrders;
	}

	public int alterSalesOrder(String id, int status) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "update t_salesorder set status=? where id=?");
			pstmt.setDouble(1, status);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int getSalesOrdersCount4User(int userid) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select count(*) from t_salesorder where userid=?");
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<SalesOrder> getSalesOrderByStatus(int status, int beginIndex,
			int sinlePageCount) {
		// TODO Auto-generated method stub
		List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select * from t_salesorder where status=? limit ?,?");
			pstmt.setInt(1, status);
			pstmt.setInt(2, beginIndex);
			pstmt.setInt(3, sinlePageCount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SalesOrder salesOrder = new SalesOrder();
				salesOrder.setId(rs.getString(1));
				salesOrder.setPdate(rs.getTimestamp(4));
				salesOrder.setRecievename(rs.getString(5));
				salesOrder.setSalesItems(salesItemDao.getSalesItemsBySalesOrderId(rs.getString(1)));
				salesOrder.setStatus(rs.getInt(9));
				salesOrders.add(salesOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salesOrders;
	}

	public int getAllOrdersCount4Admin() {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select count(*) from t_salesorder");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return result;
	}

	public int getSearchOrderCount4Admin(int status) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select count(*) from t_salesorder where status=?");
			pstmt.setInt(1, status);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, conn);
		}
		return result;
	}

}
