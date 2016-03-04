package com.shopping.liao.service.impl;

import java.util.List;

import com.shopping.empory.pojo.Product;
import com.shopping.liao.dao.FavoriteDao;
import com.shopping.liao.dao.impl.FavoriteDao4MySqlImpl;
import com.shopping.liao.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {

	private FavoriteServiceImpl(){}
	private static FavoriteDao favoriteDao = new FavoriteDao4MySqlImpl();
	private static FavoriteService favoriteService = new FavoriteServiceImpl();
	public static FavoriteService getInstance(){
		return favoriteService;
	}
	public List<Product> getFavoriteByUserid(int userid) {
		return favoriteDao.getFavoriteByUserid(userid);
	}
	public int addFavorite(int productid,int userid) {
		// TODO Auto-generated method stub
		return favoriteDao.addFavorite(productid, userid);
	}
	public int deleteFavorite(int id) {
		// TODO Auto-generated method stub
		return favoriteDao.deleteFavorite(id);
	}

}
