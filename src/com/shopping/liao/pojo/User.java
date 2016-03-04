package com.shopping.liao.pojo;

import java.util.Date;

public class User {

	private int id;
	private String username;//用户名
	private String realname;//真实姓名
	private String password;//密码
	private int postcode;//邮编
	private String phone;//手机号码
	private String address;//地址
	private Date regdate;//注册时间
	private int grade;//操作等级
	private String area;//地区
	
	//vo
	private double consumeSum;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public double getConsumeSum() {
		return consumeSum;
	}
	public void setConsumeSum(double consumeSum) {
		this.consumeSum = consumeSum;
	}
	
}
