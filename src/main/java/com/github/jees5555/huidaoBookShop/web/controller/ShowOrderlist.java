package com.github.jees5555.huidaoBookShop.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jees5555.huidaoBookShop.service.BookService;
import com.github.jees5555.huidaoBookShop.service.impl.BookServiceImpl;
import com.github.jees5555.huidaoBookShop.util.Page;

@WebServlet("/order/orderlist")
public class ShowOrderlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private BookService bs=new BookServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
			//String pagenum=request.getParameter("pagenum");
			//Page page=	bs.showPageRecords(pagenum);
			//request.setAttribute("page", page);
			request.setAttribute("model", "orderlist");
			request.getRequestDispatcher("WEB-INF/pages/orderlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}