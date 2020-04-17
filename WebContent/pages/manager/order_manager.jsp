<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<%@include file="/include/base.jsp" %>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<%@include file="/include/book-manager.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>		
			<c:forEach items="${allOrder }" var="order">
				<tr>
					<td>${order.orderId }</td>
					<td>${order.createDate }</td>
					<td>${order.totalMoney }</td>
					<td><a href="client/OrderClientServlet?method=detailed&orderId=${order.orderId }">查看详情</a></td>
					<c:choose>
						<c:when test="${order.status == 0 }">
							<td><a href="manager/OrderManagerServlet?method=deliver&orderId=${order.orderId }">点击发货</a></td>
						</c:when>
						<c:when test="${order.status == 1 }">
							<td>已发货</td>
						</c:when>
						<c:when test="${order.status == 2 }">
							<td>交易完成</td>
						</c:when>
					</c:choose>
				</tr>	
			</c:forEach>
			
		</table>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>