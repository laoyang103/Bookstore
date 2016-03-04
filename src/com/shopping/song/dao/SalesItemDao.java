package com.shopping.song.dao;

import java.util.List;

import com.shopping.song.pojo.SalesItem;

public interface SalesItemDao {
	//通过订单id查订单项
	public List<SalesItem> getSalesItemsBySalesOrderId(String salesOrderId);
	//添加订单项
	public int addSalesItem(SalesItem salesItem);
	//查某种商品的销量
	public int getProductSalesCountByPid(int productid);
}
