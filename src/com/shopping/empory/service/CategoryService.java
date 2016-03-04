package com.shopping.empory.service;

import java.util.List;

import com.shopping.empory.pojo.Category;

public interface CategoryService {
	public List<Category> getCategory();
	public List<Category> getChildenByPid(int pid);
	public Category getCategoryById(int id);
	public int addCategory(int pid,Category category);
	public int deleteCategoryById(int id);
	public int alterCategoryById(int id,Category category);
}
