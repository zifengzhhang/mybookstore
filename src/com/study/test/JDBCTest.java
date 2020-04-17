package com.study.test;

import java.sql.Connection;
import java.util.UUID;

import org.junit.Test;

import com.study.bean.Book;
import com.study.bean.User;
import com.study.utils.JDBCUtils;

public class JDBCTest {

	@Test
	public void test() {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
		
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
	}
	
}
