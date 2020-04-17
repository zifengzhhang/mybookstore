package com.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import com.study.utils.WebUtils;

public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private BookService bs = new BookServiceImpl();
    
    public BookManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
                *  显示分页数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//获取用户传来的页码
    	String pn = request.getParameter("pn");
    	Page<Book> page = bs.getPage(pn, "4");
    	
    	page.setUrl("manager/BookManagerServlet?method=page");
    	request.setAttribute("page", page);
    	
    	//返回页面显示数据
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    
    
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//取出所有图书信息
		List<Book> allbook = bs.getAll();
		
		//将数据保存
		request.setAttribute("allbook", allbook);
		
		//返回页面显示数据
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//取出图书id显示相应的图书
		String bookId = request.getParameter("id");
		Book book = bs.getBook(bookId);
		
		//保存数据
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//封装要添加的图书
		Book book = WebUtils.Param2bean(request, new Book());
		//添加图书
		bs.add(book);
		
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+request.getParameter("pn"));
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取要删除的图书id
		String bookId = request.getParameter("id");
		bs.delete(bookId);
		
		//referer代表当前页面路径
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//封装要进行操作的图书
		Book book = WebUtils.Param2bean(request, new Book());
		System.out.println(book);
		
		//判断是否带id而进行不同的操作
		if ( book.getId() == 0 ) {
			//添加图书
			bs.add(book);
		} else {
			bs.update(book);
		}
		
		//返回页面显示数据
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+request.getParameter("pn"));
	}
	
}
