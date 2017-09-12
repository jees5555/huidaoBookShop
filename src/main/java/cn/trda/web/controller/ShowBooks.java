package cn.trda.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.trda.service.BookService;
import cn.trda.service.impl.BookServiceImpl;
import cn.trda.util.Page;

@WebServlet("/showbooks")
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private BookService bs=new BookServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
			//String pagenum=request.getParameter("pagenum");
			//Page page=	bs.showPageRecords(pagenum);
			//page.setServletUrl("ShowBooks");
			//request.setAttribute("page", page);
			request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}