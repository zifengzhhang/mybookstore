package com.study.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.utils.JDBCUtils;

public class TransactionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//事务控制
		Connection connection = JDBCUtils.getConnection();
		try {
			//设置手动提交
			connection.setAutoCommit(false);
			
			//放行
			chain.doFilter(request, response);
			
			//没有错误,提交
			connection.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//事务回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			resp.sendRedirect(req.getContextPath()+"/pages/transaction/error.jsp");
		} finally {
			JDBCUtils.releaseConnection();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
