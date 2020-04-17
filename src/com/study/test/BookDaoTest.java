package com.study.test;

import java.util.List;

import org.junit.Test;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;

public class BookDaoTest {
	
	@Test
	public void test01() {
		BookService bs = new BookServiceImpl();
		
//		 bs.add(new Book(null, "猫", "老舍", 30.5, 100, 100, null)); 
//		 Book book =bs.getBook("2"); 
//		 System.out.println(book); 
//		 bs.update(new Book(2,"西游记","吴承恩",32.6,160,40,null)); 
//		 System.out.println(bs.getBook("2"));
//		 bs.add(new Book(null, "遮天", "辰东", 30.5, 100, 100, null));
//		 System.out.println(bs.getAll());
		 bs.delete("2");
		 List<Book> list = bs.getAll();
		 for ( Book book : list ) {
			 System.out.println(book);
		 }
	}
	
	@Test
	public void test() {
		Page<Book> page = new Page<Book>();
		page.setTotalRecord(28);
		int totalPage = page.getTotalPage();
		System.out.println(totalPage);
	}
}
