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
                *  ��ʾ��ҳ����
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//��ȡ�û�������ҳ��
    	String pn = request.getParameter("pn");
    	Page<Book> page = bs.getPage(pn, "4");
    	
    	page.setUrl("manager/BookManagerServlet?method=page");
    	request.setAttribute("page", page);
    	
    	//����ҳ����ʾ����
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    
    
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ȡ������ͼ����Ϣ
		List<Book> allbook = bs.getAll();
		
		//�����ݱ���
		request.setAttribute("allbook", allbook);
		
		//����ҳ����ʾ����
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ȡ��ͼ��id��ʾ��Ӧ��ͼ��
		String bookId = request.getParameter("id");
		Book book = bs.getBook(bookId);
		
		//��������
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��װҪ��ӵ�ͼ��
		Book book = WebUtils.Param2bean(request, new Book());
		//���ͼ��
		bs.add(book);
		
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+request.getParameter("pn"));
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡҪɾ����ͼ��id
		String bookId = request.getParameter("id");
		bs.delete(bookId);
		
		//referer����ǰҳ��·��
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��װҪ���в�����ͼ��
		Book book = WebUtils.Param2bean(request, new Book());
		System.out.println(book);
		
		//�ж��Ƿ��id�����в�ͬ�Ĳ���
		if ( book.getId() == 0 ) {
			//���ͼ��
			bs.add(book);
		} else {
			bs.update(book);
		}
		
		//����ҳ����ʾ����
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+request.getParameter("pn"));
	}
	
}
