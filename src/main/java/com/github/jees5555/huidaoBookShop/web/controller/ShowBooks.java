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

@WebServlet("/showbooks")
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
			String pagenum=request.getParameter("page");
			String keywords=request.getParameter("keywords");
			Page page;
			try {
				page = bs.showPageRecords(pagenum,keywords);
			
				request.setAttribute("page", page);
				request.setAttribute("model", "showbooks");
				request.setAttribute("keywords", keywords);
				request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}