package com.study.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	private static DataSource ds = new ComboPooledDataSource("webDataSource");
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = local.get();
		try {
			if ( connection == null ) {
				connection = ds.getConnection();
				
				local.set(connection);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * �ͷ����ݿ�����
	 * @param connection
	 */
	public static void releaseConnection() {
		Connection connection = local.get();
		if ( connection != null ) {
			try {
				connection.close();
				local.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
