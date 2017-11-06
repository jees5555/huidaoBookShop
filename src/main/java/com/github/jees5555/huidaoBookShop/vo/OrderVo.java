package com.github.jees5555.huidaoBookShop.vo;

import java.util.Date;
import java.util.List;

import com.github.jees5555.huidaoBookShop.entity.OrderDetail;

public class OrderVo {
	private Long oid;
	private int uid;
	
	private Integer bid;
	private Double historyBookPrice;
	private Integer count;
	
	
	private Double allprice;
	private Date createtime;
	private String status;
	
	private String bookname;
	private String image;
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Double getHistoryBookPrice() {
		return historyBookPrice;
	}
	public void setHistoryBookPrice(Double historyBookPrice) {
		this.historyBookPrice = historyBookPrice;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
