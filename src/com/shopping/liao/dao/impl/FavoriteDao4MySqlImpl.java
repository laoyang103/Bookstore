package com.shopping.liao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.empory.dao.impl.ProductDao4MySqlImpl;
import com.shopping.empory.pojo.Product;
import com.shopping.liao.dao.FavoriteDao;
import com.shopping.util.DBUtils;

public class FavoriteDao4MySqlImpl implements FavoriteDao {

	public List<Product> getFavoriteByUserid(int userid) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_favorite where userid=?");
		try {
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product = new ProductDao4MySqlImpl().getProductById(rs.getInt(3));
				products.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public int addFavorite(int productid,int userid) {
		// TODO Auto-generated method stub
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtils.getConn();
		pstmt = DBUtils.getPstmt(conn, "insert into t_favorite values(null,?,?)");
		try {
			pstmt.setInt(1, userid);
			pstmt.setInt(2, productid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int deleteFavorite(int id) {
		// TODO Auto-generated method stub
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtils.getConn();
		pstmt = DBUtils.getPstmt(conn, "delete from t_favorite where id=?");
		try {
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
