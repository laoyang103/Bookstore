package com.shopping.empory.pojo;

import java.util.Date;
import java.util.List;

public class Product {
	private int id;
	private String name;//商品名
	private int ncount;//商品当前剩余数量
	private String img;//商品图片名
	private String descr;//备注ע
	private Double normalprice;//市场价
	private Double memberprice;//会员价
	private Date pdate;//上架时间
	private int categoryid;//种类编号
	private int ifspecial;//是否特价
	//vo
	private String categoryName;//种类名
	private int salesCount;//销量
	private String parentCategory;//大类名
	private String childrenCategory;//小类名
	private List<Comment> comments;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNcount() {
		return ncount;
	}
	public void setNcount(int ncount) {
		this.ncount = ncount;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Double getNormalprice() {
		return normalprice;
	}
	public void setNormalprice(Double normalprice) {
		this.normalprice = normalprice;
	}
	public Double getMemberprice() {
		return memberprice;
	}
	public void setMemberprice(Double memberprice) {
		this.memberprice = memberprice;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getIfspecial() {
		return ifspecial;
	}
	public void setIfspecial(int ifspecial) {
		this.ifspecial = ifspecial;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}
	public String getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}
	public String getChildrenCategory() {
		return childrenCategory;
	}
	public void setChildrenCategory(String childrenCategory) {
		this.childrenCategory = childrenCategory;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
