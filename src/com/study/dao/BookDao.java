package com.study.dao;

import java.util.List;

import com.study.bean.Book;
import com.study.bean.Page;

public interface BookDao {
	
	/**
	 * ����һ��ͼ��
	 * @param book
	 */
	public void addBook(Book book);
	
	/**
	 * ����ͼ��id��ɾ��ͼ��
	 * @param bookId
	 */
	public void deleteBook(String bookId);
	
	/**
	 * ����һ��ͼ��
	 * @param book
	 */
	public void updateBook(Book book);
	
	/**
	 * ����ͼ��id����ѯһ��ͼ��
	 * @param bookId
	 * @return
	 */
	public Book getBook(String bookId);
	
	/**
	 * ��ѯ����ͼ��
	 * @return
	 */
	public List<Book> getAllBook();
	
	/**
	 * ��ѯ��ҳ��Ϣ
	 * @param page
	 * @return
	 */
	public List<Book> getPageList(int index, int size);
	
	/**
	 * ��ȡͼ���ܼ�¼��
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * ��ȡ�۸������ܼ�¼��
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public int getTotalCountByPrice(double minPrice, double maxPrice);
	
	/**
	 * ���ռ۸��ѯͼ��
	 * @param index
	 * @param size
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice);
}
