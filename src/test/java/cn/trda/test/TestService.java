package cn.trda.test;

import org.junit.Test;

import com.github.jees5555.huidaoBookShop.service.BookService;
import com.github.jees5555.huidaoBookShop.service.impl.BookServiceImpl;
import com.github.jees5555.huidaoBookShop.util.Page;

public class TestService {
	
	@Test
	public void  test1(){
		BookService bs=new BookServiceImpl();
		//client
		String pagenum="3";//service
		Page p=bs.showPageRecords(pagenum);
		
		//	servlet - setattribre("page",page)--jsp
		
	
		
	}

}
