package com.shopping.empory.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.shopping.empory.dao.ProductDao;
import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.ProductService;
import com.shopping.factory.ObjectFactory;

public class ProductServiceImpl implements ProductService {
	
	private ProductServiceImpl(){}
	private static ProductServiceImpl productSeviceImpl = new ProductServiceImpl();
	public static ProductService getInstance() {
		return productSeviceImpl;
	}
	
	private static ProductDao productDao = (ProductDao)ObjectFactory.getInstance("productDao");
	public int addProduct(Product product) {
		return productDao.addProduct(product);
	}

	public List<Product> getProductByName(int pid, String name) {
		return productDao.getProductByName(pid, name);
	}

	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	public int alterProduct(Product product) {
		return productDao.alterProduct(product);
	}

	public int deleteProductById(int id) {
		//日志
		Logger logger = Logger.getLogger(ProductServiceImpl.class);
		logger.warn("product "+getProductById(id).getName()+" is deleted.");
		return productDao.deleteProductById(id);
	}

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	public List<Product> getProductByCategoryid(int categoryid) {
		return productDao.getProductByCategoryid(categoryid);
	}

	public int addProductAmount(int productid, int amount) {
		Product product =  productDao.getProductById(productid);
		int oldNcount = product.getNcount();
		product.setNcount(oldNcount+amount);
		return productDao.alterProduct(product);
	}

	public List<Product> getProductByIfspecial(int ifspecial) {
		return productDao.getProductByIfspecial(ifspecial);
	}

	public List<Product> getNewProduct() {
		return productDao.getNewProduct();
	}

	public List<Product> getProductBySum() {
		return productDao.getProductBySum();
	}

	public List<Product> getAllProductByName(String name) {
		return productDao.getAllProductByName(name);
	}

}
