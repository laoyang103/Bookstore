package com.shopping.liao.pojo;

import java.sql.Timestamp;

public class Notice {

	private int id;
	private String title;//标题
	private String content;//内容
	private Timestamp pdate;//发布时间
	private Timestamp edate;//失效时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getPdate() {
		return pdate;
	}
	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}
	public Timestamp getEdate() {
		return edate;
	}
	public void setEdate(Timestamp edate) {
		this.edate = edate;
	}
	
	
	
	
	
}
