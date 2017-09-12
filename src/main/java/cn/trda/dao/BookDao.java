package cn.trda.dao;

import java.util.List;

import cn.trda.entity.Books;


public interface BookDao extends BaseDao<Books>{
		/**
		 * 分页显示
		 * select * from books limit 0,3;
		 */
	List<Books> showPageRecords(int startnum,int pagesize);
}
