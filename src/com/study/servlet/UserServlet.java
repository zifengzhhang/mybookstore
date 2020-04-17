package com.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;
import com.study.bean.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import com.study.utils.WebUtils;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();
	
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 处理用户的所有请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取用户输入的用户名和密码
		HttpSession session = request.getSession();
		User loginUser = WebUtils.Param2bean(request, new User());
		
		User user = us.login(loginUser);
		//判断用户名是否存在
		if ( user != null ) {
			//登录成功
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		} else {
			//登录失败
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);;
		}
		
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//防止用户重复提交
		String pageToken = request.getParameter("token");
		HttpSession session = request.getSession();
		
		String sessionToken = (String) session.getAttribute("token");
		session.removeAttribute("token");
		
		if ( !sessionToken.equals(pageToken) ) {
			response.sendRedirect(request.getContextPath()+"/pages/user/error.jsp");
			
			return;
		}
		
		//验证验证码
		//获取页面的验证码
		String pageCode = request.getParameter("code");
		
		//获取session域中的验证码
		HttpSession httpSession = request.getSession();
		String sessionCode = (String) httpSession.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		if ( !sessionCode.equals(pageCode) ) {
			request.setAttribute("msg", "验证码错误");
			response.sendRedirect(request.getContextPath()+"/pages/user/regist.jsp");
			
			return;
		}
		
		User registUser = WebUtils.Param2bean(request, new User());
		
		boolean regist = us.regist(registUser);
		
		if ( regist ) {
			//注册成功
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		} else {
			//注册失败
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);;
		}
	}
	
	/**
	 * 用户登出
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//把session强制失效
		session.invalidate();
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	protected void checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = WebUtils.Param2bean(request, new User());
		boolean result = us.checkName(user.getUsername());
		
		if ( result ) {
			response.getWriter().write("用户名已存在");
		} else {
			response.getWriter().write("用户名可用");
		}
	}
	
}
