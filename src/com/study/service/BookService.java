package com.study.service;

import java.util.List;

import com.study.bean.Book;
import com.study.bean.Page;

public interface BookService {
	
	/**
	 * 图书的业务逻辑
	 */
	
	/**
	 * 添加图书
	 * @param book
	 */
	public void add(Book book);
	
	/**
	 * 删除图书
	 * @param bookId
	 */
	public void delete(String bookId);
	
	/**
	 * 查询图书
	 * @param bookId
	 * @return
	 */
	public Book getBook(String bookId);
	
	/**
	 * 更改图书
	 * @param book
	 */
	public void update(Book book);
	
	/**
	 * 查询所有图书
	 * @return
	 */
	public List<Book> getAll();
	
	/**
	 * 返回分页数据
	 * @return
	 */
	public Page<Book> getPage(String pageNo, String pageSize);
	
	public Page<Book> getPageByPrice(String minPrice, String maxPrice, String pageNo, String pageSize);
}
