package com.shopping.empory.pojo;

import java.util.Date;

import com.shopping.liao.pojo.User;

public class Comment {
	private int id;
	private String content;  //评论内容 
	private Date cdate;  //评论时间
	private int userid;  //评论用户id
	private int productid;  //评论商品id
	//vo
	private String userName;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
