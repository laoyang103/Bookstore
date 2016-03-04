package com.shopping.song.pojo;

import java.util.Date;
import java.util.List;

import com.shopping.liao.pojo.User;

public class SalesOrder {
	   private String id;//订单号
	   private User user;//用户
	   private double totalmoney;//总计金额
	   private Date pdate;//订单时间
	   private String recievename;//收货人
	   private String address;//送货地址
	   private int paymethod;//付款方式
	   private int postcode;//邮编
	   private String phone;
	   private int recievemethod;//收货方式
	   private int timedemand;//时间要求
	   private int status;//订单状态
	   private String remark;//备注
	   private List<SalesItem> salesItems;//订单项目集合
	   
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getRecievename() {
		return recievename;
	}
	public void setRecievename(String recievename) {
		this.recievename = recievename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(int paymethod) {
		this.paymethod = paymethod;
	}
	public int getRecievemethod() {
		return recievemethod;
	}
	public void setRecievemethod(int recievemethod) {
		this.recievemethod = recievemethod;
	}
	public int getTimedemand() {
		return timedemand;
	}
	public void setTimedemand(int timedemand) {
		this.timedemand = timedemand;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<SalesItem> getSalesItems() {
		return salesItems;
	}
	public void setSalesItems(List<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
