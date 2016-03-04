package com.shopping.empory.dao;

import java.util.List;

import com.shopping.empory.pojo.Category;

public interface CategoryDao {
	public List<Category> getCategory();
	public List<Category> getChildenByPid(int pid);
	public Category getCategoryById(int id);
	public int addCategory(int pid,Category category);
	public int deleteCategoryById(int id);
	public int alterCategoryById(int id,Category category);
}
