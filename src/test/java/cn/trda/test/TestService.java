package cn.trda.test;

import org.junit.Test;

import cn.trda.service.BookService;
import cn.trda.service.impl.BookServiceImpl;
import cn.trda.util.Page;

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
