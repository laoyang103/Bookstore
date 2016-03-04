package com.shopping.liao.service.impl;

import java.util.List;

import com.shopping.factory.ObjectFactory;
import com.shopping.liao.dao.AdDao;
import com.shopping.liao.dao.UserDao;
import com.shopping.liao.pojo.Ad;
import com.shopping.liao.service.AdService;
import com.shopping.liao.service.UserService;

public class AdServiceImpl implements AdService {
	
	private AdServiceImpl() {
	}

	private static AdDao adDao = (AdDao) ObjectFactory.getInstance("adDao");
	private static AdService adService = new AdServiceImpl();

	public static AdService getInstance() {
		return adService;
	}

	public Ad getAdById(int id) {
		return adDao.getAdById(id);
	}

	public List<Ad> getAllAds() {
		// TODO Auto-generated method stub
		return adDao.getAllAds();
	}

}
