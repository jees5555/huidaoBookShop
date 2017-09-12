package cn.trda.service;

import java.util.List;

import cn.trda.entity.Books;
import cn.trda.util.Page;


public interface BookService extends BaseService<Books>{
		/**
		 * 锟斤拷页锟斤拷示
		 * select * from books limit 0,3;
		 */
	Page showPageRecords(String pagenum);
	
}
