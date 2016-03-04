package com.shopping.song.service.impl;

import java.util.List;

import com.shopping.empory.dao.ProductDao;
import com.shopping.empory.pojo.Product;
import com.shopping.empory.service.impl.ProductServiceImpl;
import com.shopping.factory.ObjectFactory;
import com.shopping.song.dao.SalesItemDao;
import com.shopping.song.pojo.SalesItem;
import com.shopping.song.service.SalesItemService;

public class SalesItemServiceImpl implements SalesItemService {
	
	private SalesItemServiceImpl(){}
	private static SalesItemServiceImpl salesItemSeviceImpl = new SalesItemServiceImpl();
	public static SalesItemService getInstance() {
		return salesItemSeviceImpl;
	}
	
	private static SalesItemDao salesItemDao = (SalesItemDao)ObjectFactory.getInstance("salesItemDao");
	private static ProductDao productDao = (ProductDao)ObjectFactory.getInstance("productDao");

	public List<SalesItem> getSalesItemsBySalesOrderId(String salesOrderId) {
		// TODO Auto-generated method stub
		return salesItemDao.getSalesItemsBySalesOrderId(salesOrderId);
	}

	public int addSalesItem(int productid, double unitprice,int pcount, String orderid) {
		// TODO Auto-generated method stub
		SalesItem salesItem = new SalesItem();
		salesItem.setProductId(productid);
		salesItem.setUnitPrice(unitprice);
		salesItem.setPcount(pcount);
		salesItem.setSalesOrderId(orderid);
		
		Product product = productDao.getProductById(productid);
		product.setNcount(product.getNcount()-pcount);
		productDao.alterProduct(product);
		
		int result = salesItemDao.addSalesItem(salesItem);
		
		return result;
	}

	public int getProductSalesCountByPid(int productid) {
		// TODO Auto-generated method stub
		return salesItemDao.getProductSalesCountByPid(productid);
	}

}
