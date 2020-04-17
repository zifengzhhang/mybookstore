package com.study.utils;

import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.study.bean.Cart;
import com.study.bean.User;

/**
 * web����ع���
 * @author Administrator
 *
 */

public class WebUtils {
	
	public static<T> T Param2bean(HttpServletRequest request, T t) {
		//��װ���󣬲�����
		//1.��ȡ��������������
		Field[] fields = t.getClass().getDeclaredFields();
		for ( Field field : fields ) {
			//��ȡ������
			String name = field.getName();
			//��request�л�ȡ��Ӧ������ֵ
			String value = request.getParameter(name);
			
			try {
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return t;
	}
	
	public static<T> T param2bean2(HttpServletRequest request, T t) {
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * ��װcar����
	 * @param request
	 * @return
	 */
	public static Cart getCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if ( cart == null ) {
			cart = new Cart();
			
			session.setAttribute("cart", cart);
		}
		
		return cart;
	}
	
	
	public static User getUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
	
		return user;
	}
}
