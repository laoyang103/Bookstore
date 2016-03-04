package com.shopping.liao.service;

import java.util.List;

import com.shopping.liao.pojo.Ad;

public interface AdService {

	public Ad getAdById(int id);
	public List<Ad> getAllAds();
}
