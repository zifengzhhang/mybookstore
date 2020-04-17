package com.study.service;

import java.util.List;

import com.study.bean.Book;
import com.study.bean.Page;

public interface BookService {
	
	/**
	 * ͼ���ҵ���߼�
	 */
	
	/**
	 * ���ͼ��
	 * @param book
	 */
	public void add(Book book);
	
	/**
	 * ɾ��ͼ��
	 * @param bookId
	 */
	public void delete(String bookId);
	
	/**
	 * ��ѯͼ��
	 * @param bookId
	 * @return
	 */
	public Book getBook(String bookId);
	
	/**
	 * ����ͼ��
	 * @param book
	 */
	public void update(Book book);
	
	/**
	 * ��ѯ����ͼ��
	 * @return
	 */
	public List<Book> getAll();
	
	/**
	 * ���ط�ҳ����
	 * @return
	 */
	public Page<Book> getPage(String pageNo, String pageSize);
	
	public Page<Book> getPageByPrice(String minPrice, String maxPrice, String pageNo, String pageSize);
}
