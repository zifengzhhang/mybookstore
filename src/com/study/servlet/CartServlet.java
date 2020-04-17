package com.study.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.study.bean.Book;
import com.study.bean.Cart;
import com.study.bean.CartItem;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import com.study.utils.WebUtils;

public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private BookService bs = new BookServiceImpl();
    
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
               * 将图书添加到购物车中
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//将购物城里的购物项保存到session
		Book book = WebUtils.Param2bean(request, new Book());
		HttpSession session = request.getSession();
		
		//从session中获取购物车，如果没有就创建
		Cart cart = WebUtils.getCart(request);
		
		//获取要添加的图书信息
		Book book2 = bs.getBook(book.getId()+"");
		cart.addBookCart(book2);
		session.setAttribute("title", book2.getTitle());
		
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
		
	}
	
	protected void AjaxaddCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookId = request.getParameter("id");
		Cart cart = WebUtils.getCart(request);
		
		Book book = bs.getBook(bookId);
		cart.addBookCart(book);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", cart.getTotalCount());
		map.put("title", book.getTitle());
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		response.getWriter().write(json);
	}
	
	/**
	 * 从购物车删除购物项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart = WebUtils.getCart(request);
		
		cart.delete(request.getParameter("id"));
		
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}
	
	/**
	 * 修改购物车里的购物项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart = WebUtils.getCart(request);
		
		cart.updateCount(request.getParameter("id"), request.getParameter("count"));
		
		String referer = request.getHeader("referer");
		if ( referer != null )
			response.sendRedirect(referer);
	}
	
	protected void AjaxUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart = WebUtils.getCart(request);
		String bookId = request.getParameter("id");
		
		cart.updateCount(bookId, request.getParameter("count"));
		CartItem item = cart.getItem(bookId);
		
		double totalPrice = item.getTotalPrice();
		int totalCount = cart.getTotalCount();
		double totalMoney = cart.getTotalMoney();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalPrice", totalPrice);
		map.put("totalCount", totalCount);
		map.put("totalMoney", totalMoney);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		response.getWriter().write(json);
		
	}
	
	
	/**
	 * 清除购物车所有的购物项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart = WebUtils.getCart(request);
		
		cart.clear();
		
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}
	
}
