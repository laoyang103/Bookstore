package com.shopping.liao.dao;

import java.util.List;

import com.shopping.empory.pojo.Product;

public interface FavoriteDao {

	public List<Product> getFavoriteByUserid(int userid);
	
	public int addFavorite(int productid,int userid);
	public int deleteFavorite(int id);
	
}
