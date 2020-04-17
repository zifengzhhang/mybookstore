package com.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.bean.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
	
	public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		boolean regist = us.regist(new User(null, username, password, email));
		if ( regist ) {
			//×¢²á³É¹¦
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.html");
		} else {
			//×¢²áÊ§°Ü
			request.getRequestDispatcher("/pages/user/regist.html");
		}
	}

}
