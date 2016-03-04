package com.shopping.empory.dao;

import java.sql.SQLException;
import java.util.List;

import com.shopping.empory.pojo.Product;

public interface ProductDao {
	public int addProduct(Product product);
	public List<Product> getProductByName(int pid,String name);
    public List<Product> getAllProduct();
    public int alterProduct(Product product);
    public int deleteProductById(int id);
    public Product getProductById(int id);
    public List<Product> getProductByCategoryid(int categoryid);
    public List<Product> getProductByIfspecial(int ifspecial);
    public List<Product> getNewProduct();
	public List<Product> getProductBySum();
	public List<Product> getAllProductByName(String name);
}
