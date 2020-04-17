package com.study.dao.impl;

import java.util.List;

import com.study.bean.Book;
import com.study.dao.BaseDao;
import com.study.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		String sql = "insert into bs_book (title, author, price, sales, stock, img_Path) values (?,?,?,?,?,?)";
		update(sql, book.getTitle(), book.getAuthor(), book.getPrice(),
				book.getSales(), book.getStock(), book.getImgPath());
	}

	@Override
	public void deleteBook(String bookId) {
		// TODO Auto-generated method stub
		String sql = "delete from bs_book where id = ?";
		update(sql, bookId);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		String sql = "update bs_book set title = ?, author = ?, price = ?, "
				+ "sales = ?, stock = ?, img_path = ? where id = ?";
		update(sql, book.getTitle(), book.getAuthor(), book.getPrice(),
				book.getSales(), book.getStock(), book.getImgPath(), book.getId());
	}

	@Override
	public Book getBook(String bookId) {
		// TODO Auto-generated method stub
		String sql = "select id, title, author, price, sales, stock, "
				+ "img_path imgPath from bs_book where id = ?";
		return getBean(sql, bookId);
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		String sql = "select id, title, author, price, sales, stock, "
				+ "img_path imgPath from bs_book";
		return getBeanList(sql);
	}

	@Override
	public List<Book> getPageList(int index, int size) {
		// TODO Auto-generated method stub
		String sql = "select id, title, author, price, sales, stock, "
				+ "img_path imgPath from bs_book limit ?,?";
		return getBeanList(sql, index, size);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from bs_book";
		Object singleValue = getSingleValue(sql);
		int count = 0;
		try {
			count = Integer.parseInt(singleValue.toString());
		} catch (NumberFormatException e ) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getTotalCountByPrice(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from bs_book where price between ? and ?";
		Object singleValue = getSingleValue(sql, minPrice, maxPrice);
		int count = 0;
		try {
			count = Integer.parseInt(singleValue.toString());
		} catch (NumberFormatException e ) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		String sql = "select id, title, author, price, sales, stock, img_path imgPath "
				+ "from bs_book where price between ? and ? limit ?,?";
		return getBeanList(sql, minPrice, maxPrice, index, size);
	}

}
