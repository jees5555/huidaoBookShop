package com.github.jees5555.huidaoBookShop.dao;

import java.util.List;

import com.github.jees5555.huidaoBookShop.entity.Books;


public interface BookDao extends BaseDao<Books>{
		/**
		 * 分页显示
		 * select * from books limit 0,3;
		 */
	List<Books> showPageRecords(int startnum,int pagesize);
}
