package com.shopping.song.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import com.shopping.factory.ObjectFactory;
import com.shopping.liao.dao.UserDao;
import com.shopping.song.dao.SalesOrderDao;
import com.shopping.song.pojo.SalesOrder;
import com.shopping.song.service.SalesOrderService;

public class SalesOrderServiceImpl implements SalesOrderService {
	
	private SalesOrderServiceImpl(){}
	private static SalesOrderServiceImpl salesOrderSeviceImpl = new SalesOrderServiceImpl();
	public static SalesOrderServiceImpl getInstance() {
		return salesOrderSeviceImpl;
	}
	
	private static SalesOrderDao salesOrderDao = (SalesOrderDao)ObjectFactory.getInstance("salesOrderDao");
	private static UserDao userDao = (UserDao)ObjectFactory.getInstance("userDao");

	public List<SalesOrder> getSalesOrdersByUid(int userid,int page,int singlePageCount) {
		// TODO Auto-generated method stub
		int beginIndex = (page-1)*5;
		return salesOrderDao.getSalesOrdersByUid(userid,beginIndex,singlePageCount);
	}

	public int deleteSalesOrderById(String id) {
		// TODO Auto-generated method stub
		//日志处理
		Logger logger = Logger.getLogger(SalesOrderServiceImpl.class);
		logger.warn("saleorder "+id+" is deleted.");
		
		return salesOrderDao.deleteSalesOrderById(id);
	}

	public SalesOrder getSalesOrderById(String id) {
		// TODO Auto-generated method stub
		return salesOrderDao.getSalesOrderById(id);
	}

	public int addSalesOrder(String id,int userid,double totalmoney,String recievename, String address,
			int postcode, String phone, int paymethod, int recievemethod,
			int timedemand,int status, String remark) {
		// TODO Auto-generated method stub
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setId(id);
		salesOrder.setUser(userDao.getUserByUid(userid));
		salesOrder.setTotalmoney(totalmoney);
		salesOrder.setRecievename(recievename);
		salesOrder.setAddress(address);
		salesOrder.setPostcode(postcode);
		salesOrder.setPhone(phone);
		salesOrder.setPaymethod(paymethod);
		salesOrder.setRecievemethod(recievemethod);
		salesOrder.setTimedemand(timedemand);
		salesOrder.setStatus(status);
		salesOrder.setRemark(remark);
		
		int result = salesOrderDao.addSalesOrder(salesOrder);
		return result;
	}

	public int alterSalesOrder(String id, double totalmoney) {
		// TODO Auto-generated method stub
		//日志处理
		Logger logger = Logger.getLogger(SalesOrderServiceImpl.class);
		logger.warn("saleorder "+id+" is altered");
		
		return salesOrderDao.alterSalesOrder(id, totalmoney);
	}

	public List<SalesOrder> getAllSalesOrders(int page,int singlePageCount) {
		// TODO Auto-generated method stub
		int beginIndex = (page-1)*singlePageCount;
		return salesOrderDao.getAllSalesOrders(beginIndex,singlePageCount);
	}

	public int alterSalesOrder(String id, int status) {
		// TODO Auto-generated method stub
		return salesOrderDao.alterSalesOrder(id, status);
	}

	public int getSalesOrdersCount4User(int userid) {
		// TODO Auto-generated method stub
		return salesOrderDao.getSalesOrdersCount4User(userid);
	}

	public List<SalesOrder> getSalesOrderByStatus(int status, int page,
			int sinlePageCount) {
		// TODO Auto-generated method stub
		int beginIndex = (page-1)*sinlePageCount;
		return salesOrderDao.getSalesOrderByStatus(status, beginIndex, sinlePageCount);
	}

	public int getAllOrdersCount4Admin() {
		// TODO Auto-generated method stub
		return salesOrderDao.getAllOrdersCount4Admin();
	}

	public int getSearchOrderCount4Admin(int status) {
		// TODO Auto-generated method stub
		return salesOrderDao.getSearchOrderCount4Admin(status);
	}

}
