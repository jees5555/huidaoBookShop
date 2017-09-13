package com.github.jees5555.huidaoBookShop.service.impl;

import java.util.List;

import com.github.jees5555.huidaoBookShop.dao.BookDao;
import com.github.jees5555.huidaoBookShop.dao.impl.BookDaoImpl;
import com.github.jees5555.huidaoBookShop.entity.Books;
import com.github.jees5555.huidaoBookShop.service.BookService;
import com.github.jees5555.huidaoBookShop.util.Page;

public class BookServiceImpl implements BookService{
	private BookDao bd=new BookDaoImpl();
	@Override
	public int findAllRecords() {
		// TODO Auto-generated method stub
		return bd.findAllRecords();
	}

	@Override
	public Page showPageRecords(String pagenum) {
		// TODO 业务
		int num=1;
		if(pagenum!=null){
			num=Integer.parseInt(pagenum);
		}
		int totalRecords=bd.findAllRecords();
		Page page=new Page(num,totalRecords);
		
		List<Books> books=bd.showPageRecords(page.getStartIndex(), page.getPagesize());
		page.setRecords(books);
		return page;
	}
	
	
	@Override
	public int add(Books t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(Books t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Books t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Books findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



}