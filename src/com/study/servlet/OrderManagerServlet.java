package com.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.bean.Contants;
import com.study.bean.Order;
import com.study.service.OrderItemService;
import com.study.service.OrderService;
import com.study.service.impl.OrderItemServiceImpl;
import com.study.service.impl.OrderServiceImpl;
 
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os = new OrderServiceImpl();
	private OrderItemService oItem = new OrderItemServiceImpl();
       
    public OrderManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
               * 获取所有订单，管理员操作
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	protected void allOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Order> allOrder = os.getAllOrder();
		
		request.setAttribute("allOrder", allOrder);
		
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
		
	}
	
	/**
	 * 发货
	 */
	protected void deliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderId = request.getParameter("orderId");
		
		os.updateStatus(orderId, Contants.DELIVERED);
		
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}

}
