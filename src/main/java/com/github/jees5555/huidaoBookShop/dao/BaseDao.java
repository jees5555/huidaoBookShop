package com.github.jees5555.huidaoBookShop.dao;

import java.util.List;

import com.github.jees5555.huidaoBookShop.entity.Users;

/**
 * 
 * 杭州汇到：T  type  E  element  K  key   V   value
 * 描述:定义增删改查的接口
 *	@author Administrator
 *	
 */
public interface BaseDao<T>{
	/**
	 * 增加
	 */
	int add(T t);
	/**
	 * 删除
	 */
	int del(T t);
	/**
	 * 更新
	 */
	int update(T t);
	/**
	 * 查询 1个
	 */
	T findById(int id);
	/**
	 * 查询一堆
	 */
	@Deprecated
	List<T> findAll();
	
	/**
	 * 获取信息的总条数
	 */
	int findAllRecords();

}
