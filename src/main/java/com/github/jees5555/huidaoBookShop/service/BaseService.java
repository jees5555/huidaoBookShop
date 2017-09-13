package com.github.jees5555.huidaoBookShop.service;

import java.util.List;

import com.github.jees5555.huidaoBookShop.entity.Users;

/**
 * 
 * 锟斤拷锟捷汇到锟斤拷T  type  E  element  K  key   V   value
 * 锟斤拷锟斤拷:锟斤拷锟斤拷锟斤拷删锟侥诧拷慕涌锟?
 *	@author Administrator
 *	
 */
public interface BaseService<T>{
	/**
	 * 锟斤拷锟斤拷
	 */
	int add(T t);
	/**
	 * 删除
	 */
	int del(T t);
	/**
	 * 修改
	 */
	int update(T t);
	/**
	 * 查询 1锟斤拷
	 */
	T findById(int id);
	/**
	 * 查询一锟斤拷
	 */
	@Deprecated
	List<T> findAll();
	
	/**
	 * 锟斤拷取锟斤拷息锟斤拷锟斤拷锟斤拷锟斤拷
	 */
	int findAllRecords();
}