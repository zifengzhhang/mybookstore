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
		//��ֹ�û������ַ������������ת�ʹ���
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
		//�������ܼ�¼��
		int totalCount = bd.getTotalCount();
		page.setTotalRecord(totalCount);
		//�������������ҳ��
		page.setPageNo(pn);
		
		//��ѯ��ҳ����
		List<Book> pageList = bd.getPageList(page.getIndex(), page.getPagesize());
		//�����ݷ�װ��page����
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
		//�Ȼ�ȡ�۸������ܼ�¼��
		int totalCount = bd.getTotalCountByPrice(min, max);
		page.setTotalRecord(totalCount);
		
		page.setPageNo(pn);
		//��ѯ��ҳ����
		List<Book> pageList = bd.getPageByPrice(page.getIndex(), page.getPagesize(), min, max);
		//�����ݷ�װ��page����
		page.setPageData(pageList);
		return page;
	}

}
