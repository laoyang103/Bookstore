package com.shopping.empory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.empory.dao.CategoryDao;
import com.shopping.empory.dao.ProductDao;
import com.shopping.empory.pojo.Product;
import com.shopping.factory.ObjectFactory;
import com.shopping.song.dao.SalesItemDao;
import com.shopping.util.DBUtils;

public class ProductDao4MySqlImpl implements ProductDao {
	
	private static CategoryDao categoryDao = (CategoryDao)ObjectFactory.getInstance("categoryDao");
	private static SalesItemDao salesItemDao = (SalesItemDao)ObjectFactory.getInstance("salesItemDao");
	private static ProductDao productDao = (ProductDao)ObjectFactory.getInstance("productDao");

	public int addProduct(Product product) {
		int n= 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "insert into t_product values(null,?,?,?,?,?,?,now(),?,?)");
		try {
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, 0);
			pstmt.setString(3, product.getImg());
			pstmt.setString(4, product.getDescr());
			pstmt.setDouble(5, product.getNormalprice());
			pstmt.setDouble(6, product.getMemberprice());
			pstmt.setInt(7, product.getCategoryid());
			pstmt.setInt(8, product.getIfspecial());
			
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}	
		return n;
	}

	public List<Product> getProductByName(int pid,String name) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_product where name like '%"+name+"%' and categoryid in (select distinct id from t_category where pid=?)");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNcount(rs.getInt(3));
				product.setImg(rs.getString(4));
				product.setDescr(rs.getString(5));
				product.setNormalprice(rs.getDouble(6));
				product.setMemberprice(rs.getDouble(7));
				product.setPdate(rs.getDate(8));
				product.setCategoryid(rs.getInt(9));
				product.setIfspecial(rs.getInt(10));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return products;
	}

	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_product");
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNcount(rs.getInt(3));
				product.setImg(rs.getString(4));
				product.setDescr(rs.getString(5));
				product.setNormalprice(rs.getDouble(6));
				product.setMemberprice(rs.getDouble(7));
				product.setPdate(rs.getDate(8));
				product.setCategoryid(rs.getInt(9));
				product.setIfspecial(rs.getInt(10));
				//vo
				product.setCategoryName(categoryDao.getCategoryById(rs.getInt(9)).getName());
				product.setSalesCount(salesItemDao.getProductSalesCountByPid(rs.getInt(1)));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return products;
	}

	public int alterProduct(Product product) {
		int n = 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "update t_product set name = ?,img = ?,descr = ?,normalprice = ?,memberprice = ?,categoryid = ?,ifspecial = ? , ncount=? where id = ?");
		try {
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getImg());
			pstmt.setString(3, product.getDescr());
			pstmt.setDouble(4, product.getNormalprice());
			pstmt.setDouble(5, product.getMemberprice());
			pstmt.setInt(6, product.getCategoryid());
			pstmt.setInt(7, product.getIfspecial());
			pstmt.setInt(8, product.getNcount());
			pstmt.setInt(9, product.getId());
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}
		return n;
	}

	public int deleteProductById(int id) {
		int n = 0;
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "delete from t_product where id = ?");
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

	public Product getProductById(int id) {
		Product product = new Product();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_product where id = ?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNcount(rs.getInt(3));
				product.setImg(rs.getString(4));
				product.setDescr(rs.getString(5));
				product.setNormalprice(rs.getDouble(6));
				product.setMemberprice(rs.getDouble(7));
				product.setPdate(rs.getDate(8));
				product.setCategoryid(rs.getInt(9));
				product.setIfspecial(rs.getInt(10));
				
//				product.setParentCategory(parentCategory)
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}		
		return product;
	}

	public List<Product> getProductByCategoryid(int categoryid) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_product where categoryid=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, categoryid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNcount(rs.getInt(3));
				product.setImg(rs.getString(4));
				product.setDescr(rs.getString(5));
				product.setNormalprice(rs.getDouble(6));
				product.setMemberprice(rs.getDouble(7));
				product.setPdate(rs.getDate(8));
				product.setCategoryid(rs.getInt(9));
				product.setIfspecial(rs.getInt(10));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return products;
	}
	
	public List<Product> getProductByIfspecial(int ifspecial) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_product where ifspecial=? order by pdate DESC");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, ifspecial);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNcount(rs.getInt(3));
				product.setImg(rs.getString(4));
				product.setDescr(rs.getString(5));
				product.setNormalprice(rs.getDouble(6));
				product.setMemberprice(rs.getDouble(7));
				product.setPdate(rs.getDate(8));
				product.setCategoryid(rs.getInt(9));
				product.setIfspecial(rs.getInt(10));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return products;
	}

	public List<Product> getNewProduct() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_product where DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= date(pdate) ORDER BY pdate DESC limit 0,5");
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNcount(rs.getInt(3));
				product.setImg(rs.getString(4));
				product.setDescr(rs.getString(5));
				product.setNormalprice(rs.getDouble(6));
				product.setMemberprice(rs.getDouble(7));
				product.setPdate(rs.getDate(8));
				product.setCategoryid(rs.getInt(9));
				product.setIfspecial(rs.getInt(10));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return products;
	}

	public List<Product> getProductBySum() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select productid,sum(pcount) from t_salesitem group by productid limit 7");
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = productDao.getProductById(rs.getInt(1));
				product.setSalesCount(rs.getInt(2));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return products;
	}

	public List<Product> getAllProductByName(String name) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = DBUtils.getPstmt(conn, "select * from t_product where name like '%"+name+"%'");
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNcount(rs.getInt(3));
				product.setImg(rs.getString(4));
				product.setDescr(rs.getString(5));
				product.setNormalprice(rs.getDouble(6));
				product.setMemberprice(rs.getDouble(7));
				product.setPdate(rs.getDate(8));
				product.setCategoryid(rs.getInt(9));
				product.setIfspecial(rs.getInt(10));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return products;
	}

}

