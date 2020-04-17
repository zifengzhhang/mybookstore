package com.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.bean.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取用户输入的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = us.login(new User(null, username, password, null));
		//判断用户名是否存在
		if ( user != null ) {
			//登录成功
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
		} else {
			//登录失败
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);;
		}
	}

}
