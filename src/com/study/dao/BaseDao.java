package com.study.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.study.utils.JDBCUtils;

public class BaseDao<T> {
	
	private QueryRunner runner =  new QueryRunner();
	private Class<T> type;
	
	public BaseDao() {
		//子类获取父类的泛型参数
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		type = (Class<T>) superclass.getActualTypeArguments()[0];
	}
	
	/**
	 * 获取一个对象是集合
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql, Object...params) {
		Connection connection = JDBCUtils.getConnection();
		List<T> query = null; 
		try {
			query = runner.query(connection, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} 
		
		return query;
	}
	
	/**
	 * 获取一个对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql, Object...params) {
		Connection connection = JDBCUtils.getConnection();
		T query = null;
		try {
			query = runner.query(connection, sql, new BeanHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} 
		
		return query;
		
	}
	
	public int update(String sql, Object...params) {
		Connection connection = JDBCUtils.getConnection();
		int count = 0;
		try {
			count = runner.update(connection, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} 
		
		return count;
	}
	
	/**
	 * 查询单个值
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getSingleValue(String sql, Object...params) {
		Connection connection = JDBCUtils.getConnection();
		Object value = null;
		try {
			value = runner.query(connection, sql, new ScalarHandler<>(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} 
		
		return value;
	}
	
	/**
	 * 批量保存订单
	 * @param sql
	 * @param params
	 * @return
	 */
	public int Batchsave(String sql, Object[][] params) {
		Connection connection = JDBCUtils.getConnection();
		try {
			runner.batch(connection, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} 
		
		return 1;
	}
}
