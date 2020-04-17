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
     * �����û�����������
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ�û�������û���������
		HttpSession session = request.getSession();
		User loginUser = WebUtils.Param2bean(request, new User());
		
		User user = us.login(loginUser);
		//�ж��û����Ƿ����
		if ( user != null ) {
			//��¼�ɹ�
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		} else {
			//��¼ʧ��
			request.setAttribute("msg", "�û������������");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);;
		}
		
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ֹ�û��ظ��ύ
		String pageToken = request.getParameter("token");
		HttpSession session = request.getSession();
		
		String sessionToken = (String) session.getAttribute("token");
		session.removeAttribute("token");
		
		if ( !sessionToken.equals(pageToken) ) {
			response.sendRedirect(request.getContextPath()+"/pages/user/error.jsp");
			
			return;
		}
		
		//��֤��֤��
		//��ȡҳ�����֤��
		String pageCode = request.getParameter("code");
		
		//��ȡsession���е���֤��
		HttpSession httpSession = request.getSession();
		String sessionCode = (String) httpSession.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		if ( !sessionCode.equals(pageCode) ) {
			request.setAttribute("msg", "��֤�����");
			response.sendRedirect(request.getContextPath()+"/pages/user/regist.jsp");
			
			return;
		}
		
		User registUser = WebUtils.Param2bean(request, new User());
		
		boolean regist = us.regist(registUser);
		
		if ( regist ) {
			//ע��ɹ�
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		} else {
			//ע��ʧ��
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);;
		}
	}
	
	/**
	 * �û��ǳ�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//��sessionǿ��ʧЧ
		session.invalidate();
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	protected void checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = WebUtils.Param2bean(request, new User());
		boolean result = us.checkName(user.getUsername());
		
		if ( result ) {
			response.getWriter().write("�û����Ѵ���");
		} else {
			response.getWriter().write("�û�������");
		}
	}
	
}
