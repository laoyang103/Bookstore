package com.shopping.liao.pojo;

import java.util.List;

import com.shopping.empory.pojo.Product;

public class Favorite {

	private int id;
	private User user;
	private List<Product> products;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
