package com.shopping.empory.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.shopping.empory.dao.CategoryDao;
import com.shopping.empory.pojo.Category;
import com.shopping.empory.service.CategoryService;
import com.shopping.factory.ObjectFactory;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryServiceImpl(){}
	private static CategoryServiceImpl categorySeviceImpl = new CategoryServiceImpl();
	public static CategoryService getInstance() {
		return categorySeviceImpl;
	}
	
	private static CategoryDao categoryDao = (CategoryDao)ObjectFactory.getInstance("categoryDao");
	
	public List<Category> getCategory() {
		return categoryDao.getCategory();
	}

	public List<Category> getChildenByPid(int pid) {
		return categoryDao.getChildenByPid(pid);
	}

	public Category getCategoryById(int id) {
		return categoryDao.getCategoryById(id);
	}

	public int deleteCategoryById(int id) {
		//日志
		Logger logger = Logger.getLogger(CategoryServiceImpl.class);
		logger.warn("category "+getCategoryById(id).getName()+" is deleted.");
		return categoryDao.deleteCategoryById(id);
	}

	public int addCategory(int pid, Category category) {
		return categoryDao.addCategory(pid, category);
	}

	public int alterCategoryById(int id, Category category) {
		return categoryDao.alterCategoryById(id, category);
	}

}
