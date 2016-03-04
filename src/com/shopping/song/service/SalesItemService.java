package com.shopping.song.service;

import java.util.List;

import com.shopping.song.pojo.SalesItem;

public interface SalesItemService {
	//通过订单id查订单项
	public List<SalesItem> getSalesItemsBySalesOrderId(String salesOrderId);
	//添加订单项
	public int addSalesItem(int productid,double unitprice,int pcount,String orderid);
	//查某个商品的销量
	public int getProductSalesCountByPid(int productid);
}
