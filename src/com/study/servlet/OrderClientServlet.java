package com.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.bean.Cart;
import com.study.bean.Contants;
import com.study.bean.Order;
import com.study.bean.OrderItem;
import com.study.bean.User;
import com.study.service.OrderItemService;
import com.study.service.OrderService;
import com.study.service.impl.OrderItemServiceImpl;
import com.study.service.impl.OrderServiceImpl;
import com.study.utils.WebUtils;

public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private OrderService os = new OrderServiceImpl();
	private OrderItemService oItem = new OrderItemServiceImpl();
	
    public OrderClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���˲���
		HttpSession session = request.getSession();
		User user = WebUtils.getUser(request);
		
		Cart cart = WebUtils.getCart(request);
		
		//���ؽ��㶩���Ų�����
		String orderId = os.checkout(cart, user);
		session.setAttribute("orderId", orderId);
		
		response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
		
	}
	
	/**
	 * �г��û����ж���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void allUserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ��ǰ�û������ж���
		User user = WebUtils.getUser(request);
		List<Order> allOrder = os.getUserByOrder(user.getId());
		
		//���淵�ظ�ҳ����ʾ
		request.setAttribute("allOrder", allOrder);
		
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	/**
	 * ��ȡ���������ж�������Ϣ
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void detailed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderId = request.getParameter("orderId");
		List<OrderItem> allOrderItem = oItem.getOrderItem(orderId);
		
		request.setAttribute("allOrderItem", allOrderItem);
		
		request.getRequestDispatcher("/pages/order/orderitem.jsp").forward(request, response);
		
	}
	
	/**
	 * �û�ȷ���ջ�
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void receiving(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderId = request.getParameter("orderId");

		//�޸Ķ���״̬
		os.updateStatus(orderId, Contants.RECEIVED);
		
		String refere = request.getHeader("referer");
		response.sendRedirect(refere);
	}
	
}
