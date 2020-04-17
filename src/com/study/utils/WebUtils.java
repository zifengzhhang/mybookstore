package com.study.utils;

import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.study.bean.Cart;
import com.study.bean.User;

/**
 * web的相关工具
 * @author Administrator
 *
 */

public class WebUtils {
	
	public static<T> T Param2bean(HttpServletRequest request, T t) {
		//封装对象，并返回
		//1.获取所有声明的属性
		Field[] fields = t.getClass().getDeclaredFields();
		for ( Field field : fields ) {
			//获取属性名
			String name = field.getName();
			//在request中获取相应的属性值
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
	 * 封装car对象
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
