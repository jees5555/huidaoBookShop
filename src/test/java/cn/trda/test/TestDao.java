package cn.trda.test;

import java.util.List;

import org.junit.Test;

import com.github.jees5555.huidaoBookShop.dao.BookDao;
import com.github.jees5555.huidaoBookShop.dao.impl.BookDaoImpl;
import com.github.jees5555.huidaoBookShop.entity.Books;

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
