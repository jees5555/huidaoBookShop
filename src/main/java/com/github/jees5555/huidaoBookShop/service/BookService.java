package com.github.jees5555.huidaoBookShop.service;

import java.util.List;

import com.github.jees5555.huidaoBookShop.entity.Books;
import com.github.jees5555.huidaoBookShop.util.Page;


public interface BookService extends BaseService<Books>{
		/**
		 * 锟斤拷页锟斤拷示
		 * select * from books limit 0,3;
		 */
	Page showPageRecords(String pagenum);
	
}
