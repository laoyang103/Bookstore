package com.shopping.liao.dao;

import java.util.List;

import com.shopping.liao.pojo.Ad;

public interface AdDao {

	public Ad getAdById(int id);
	public List<Ad> getAllAds();
}
