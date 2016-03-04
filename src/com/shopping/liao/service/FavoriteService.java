package com.shopping.liao.service;

import java.util.List;

import com.shopping.empory.pojo.Product;
import com.shopping.liao.pojo.Favorite;

public interface FavoriteService {

	public List<Product> getFavoriteByUserid(int userid);
	
	public int addFavorite(int productid,int userid);
	public int deleteFavorite(int id);
}
