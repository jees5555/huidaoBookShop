package com.github.jees5555.huidaoBookShop.entity;

import java.util.Date;

public class Items {
	private int iid;
	private int oid;
	private int bid;
	private Date createdate;
	
	private int bookCount;
	private float price;
	private String stat;
	private float totalprice;
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	
	
	
}
