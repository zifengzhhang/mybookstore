package com.study.service.impl;

import java.util.List;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.dao.BookDao;
import com.study.dao.impl.BookDaoImpl;
import com.study.service.BookService;

public class BookServiceImpl implements BookService {
	
	private BookDao bd = new BookDaoImpl();
	
	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		bd.addBook(book);
	}

	@Override
	public void delete(String bookId) {
		// TODO Auto-generated method stub
		bd.deleteBook(bookId);
	}

	@Override
	public Book getBook(String bookId) {
		// TODO Auto-generated method stub
		return bd.getBook(bookId);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bd.updateBook(book);
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bd.getAllBook();
	}

	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		Page<Book> page = new Page<Book>();
		//防止用户输入字符串在这里进行转型处理
		int pn = 1;
		int ps = page.getPagesize();
		try {
			pn = Integer.parseInt(pageNo);
			//Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		//先设置总记录数
		int totalCount = bd.getTotalCount();
		page.setTotalRecord(totalCount);
		//这样可以算出总页数
		page.setPageNo(pn);
		
		//查询分页数据
		List<Book> pageList = bd.getPageList(page.getIndex(), page.getPagesize());
		//把数据封装进page对象
		page.setPageData(pageList);
		return page;
	}

	@Override
	public Page<Book> getPageByPrice(String minPrice, String maxPrice, String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		double min = 0.0;
		double max = Double.MAX_VALUE;
		try {
			min = Double.parseDouble(minPrice);
			max = Double.parseDouble(maxPrice);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Page<Book> page = new Page<Book>();
		int pn = 1;
		int ps = page.getPagesize();
		try {
			pn = Integer.parseInt(pageNo);
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//先获取价格区间总记录数
		int totalCount = bd.getTotalCountByPrice(min, max);
		page.setTotalRecord(totalCount);
		
		page.setPageNo(pn);
		//查询分页数据
		List<Book> pageList = bd.getPageByPrice(page.getIndex(), page.getPagesize(), min, max);
		//把数据封装进page对象
		page.setPageData(pageList);
		return page;
	}

}
