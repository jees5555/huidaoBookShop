package com.github.jees5555.huidaoBookShop.entity;

public class OrderDetail {
	private int oid;
	private Book book;
	private int count;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
