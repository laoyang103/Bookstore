package com.shopping.liao.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.liao.dao.AdDao;
import com.shopping.liao.pojo.Ad;
import com.shopping.util.DBUtils;

public class AdDao4MySqlImpl implements AdDao {

	public Ad getAdById(int id) {
		Ad ad = new Ad();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select*from t_ad where id=?");		
		ResultSet rs = null;
		try {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ad.setId(id);
				ad.setImg(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ad;
	}

	public List<Ad> getAllAds() {
		// TODO Auto-generated method stub
		List<Ad> ads = new ArrayList<Ad>();
		
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			pstmt = DBUtils.getPstmt(conn, "select * from t_ad");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Ad ad = new Ad();
				ad.setId(rs.getInt(1));
				ad.setImg(rs.getString(2));
				
				ads.add(ad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ads;
	}

}
