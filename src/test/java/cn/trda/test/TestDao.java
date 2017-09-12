package cn.trda.test;

import java.util.List;

import org.junit.Test;

import cn.trda.dao.BookDao;
import cn.trda.dao.impl.BookDaoImpl;
import cn.trda.entity.Books;

public class TestDao {
		
	//jnuit 4
	@Test
	public void testBookDao(){
		BookDao bd=new BookDaoImpl();//多态
		int a=bd.findAllRecords();
		List<Books> books=bd.showPageRecords(0, 3);
		System.out.println(books);
		
	}
	
	
}
