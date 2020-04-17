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
		//��ȡ�û�������û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = us.login(new User(null, username, password, null));
		//�ж��û����Ƿ����
		if ( user != null ) {
			//��¼�ɹ�
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
		} else {
			//��¼ʧ��
			request.setAttribute("msg", "�û������������");
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);;
		}
	}

}
