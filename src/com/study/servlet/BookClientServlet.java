package com.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;

public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs = new BookServiceImpl();
	
    public BookClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("我是前端分页方法");
		//获取用户传来的页码
		String pn = request.getParameter("pn");
		Page<Book> page = bs.getPage(pn, "4");
		
		//将第一页的数据显示给页面
		page.setUrl("client/BookClientServlet?method=page");
		request.setAttribute("page", page);
		
		//返回页面显示数据
		request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
		
	}

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		String pn = request.getParameter("pn");
		
		//查询价格区间所有图书
		Page<Book> page = bs.getPageByPrice(min, max, pn, "4");
		page.setUrl("client/BookClientServlet?method=pageByPrice&max="+max+"&min="+min);
		request.setAttribute("page", page);
		
		//返回页面显示数据
		request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}

}
