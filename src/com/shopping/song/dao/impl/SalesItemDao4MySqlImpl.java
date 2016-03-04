package com.shopping.song.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.empory.dao.ProductDao;
import com.shopping.factory.ObjectFactory;
import com.shopping.song.dao.SalesItemDao;
import com.shopping.song.pojo.SalesItem;
import com.shopping.util.DBUtils;

public class SalesItemDao4MySqlImpl implements SalesItemDao {
	
	private static ProductDao productDao = (ProductDao)ObjectFactory.getInstance("productDao");

	public List<SalesItem> getSalesItemsBySalesOrderId(String salesOrderId) {
		List<SalesItem> salesItems = new ArrayList<SalesItem>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select * from t_salesitem where orderid=?");
			pstmt.setString(1, salesOrderId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SalesItem salesItem = new SalesItem();
				salesItem.setId(rs.getInt(1));
				//salesItem.setProduct(product)
				salesItem.setProductId(rs.getInt(2));
				salesItem.setProductName(productDao.getProductById(rs.getInt(2)).getName());
				salesItem.setUnitPrice(rs.getDouble(3));
				salesItem.setPcount(rs.getInt(4));
				//salesItem.setSalesOrder(salesOrder)
				salesItem.setSalesOrderId(rs.getString(5));
				
				salesItems.add(salesItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salesItems;
	}

	public int addSalesItem(SalesItem salesItem) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "insert into t_salesitem values(null,?,?,?,?)");
			pstmt.setInt(1, salesItem.getProductId());
			pstmt.setDouble(2, salesItem.getUnitPrice());
			pstmt.setInt(3, salesItem.getPcount());
			pstmt.setString(4, salesItem.getSalesOrderId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int getProductSalesCountByPid(int productid) {
		// TODO Auto-generated method stub
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select sum(pcount) from t_salesitem where productid=?");
			pstmt.setInt(1, productid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
