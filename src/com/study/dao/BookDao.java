package com.study.dao;

import java.util.List;

import com.study.bean.Book;
import com.study.bean.Page;

public interface BookDao {
	
	/**
	 * 插入一本图书
	 * @param book
	 */
	public void addBook(Book book);
	
	/**
	 * 根据图书id来删除图书
	 * @param bookId
	 */
	public void deleteBook(String bookId);
	
	/**
	 * 更新一本图书
	 * @param book
	 */
	public void updateBook(Book book);
	
	/**
	 * 根据图书id来查询一本图书
	 * @param bookId
	 * @return
	 */
	public Book getBook(String bookId);
	
	/**
	 * 查询所有图书
	 * @return
	 */
	public List<Book> getAllBook();
	
	/**
	 * 查询分页信息
	 * @param page
	 * @return
	 */
	public List<Book> getPageList(int index, int size);
	
	/**
	 * 获取图书总记录数
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 获取价格区间总记录数
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public int getTotalCountByPrice(double minPrice, double maxPrice);
	
	/**
	 * 按照价格查询图书
	 * @param index
	 * @param size
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice);
}
