package com.shopping.song.service;

import java.util.List;

import com.shopping.song.pojo.SalesOrder;

public interface SalesOrderService {
	//通过userid查订单列表
	public List<SalesOrder> getSalesOrdersByUid(int userid,int page,int singlePageCount);
	//通过订单id取消订单
	public int deleteSalesOrderById(String id);
	//通过订单id查询订单详情
	public SalesOrder getSalesOrderById(String id);
	//查询出所有的订单
	public List<SalesOrder> getAllSalesOrders(int page,int singlePageCount);
	//添加新订单
	public int addSalesOrder(String id,int userid,double totalmoney,String recievename,String address,int postcode,String phone,int paymethod,int recievemethod,int timedemand,int status,String remark);
	//修改订单总价格
	public int alterSalesOrder(String id,double totalmoney);
	//修改订单的状态
	public int alterSalesOrder(String id,int status);
	//拿到用户的订单总数
	public int getSalesOrdersCount4User(int userid);
	//拿到所有订单是数目
	public int getAllOrdersCount4Admin();
	//拿到相应订单状态的订单的总数目
	public int getSearchOrderCount4Admin(int status);
	//通过订单状态查找
	public List<SalesOrder> getSalesOrderByStatus(int status,int page,int sinlePageCount);
}
