package com.github.jees5555.huidaoBookShop.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	private int oid;
	private int uid;
	private List<OrderDetail> orderdetail;
	private float allprice;
	private LocalDateTime createtime;
	private String status;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public List<OrderDetail> getOrderdetail() {
		return orderdetail;
	}
	public void setOrderdetail(List<OrderDetail> orderdetail) {
		this.orderdetail = orderdetail;
	}
	public float getAllprice() {
		return allprice;
	}
	public void setAllprice(float allprice) {
		this.allprice = allprice;
	}
	public LocalDateTime getCreatetime() {
		return createtime;
	}
	public void setCreatetime(LocalDateTime createtime) {
		this.createtime = createtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
