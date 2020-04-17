<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@include file="/include/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@include file="/include/user-info.jsp" %>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${allOrder }" var="order">
				<tr>
					<td>${order.orderId }</td>
					<td>${order.createDate }</td>
					<td>${order.totalMoney }</td>
					<c:choose>
						<c:when test="${order.status == 0 }">
							<td>未发货</td>
						</c:when>
						<c:when test="${order.status == 1 }">
							<td><a href="client/OrderClientServlet?method=receiving&orderId=${order.orderId }">确认收货</a></td>
						</c:when>
						<c:when test="${order.status == 2 }">
							<td>已收货</td>
						</c:when>
					</c:choose>
					<td><a href="client/OrderClientServlet?method=detailed&orderId=${order.orderId }">查看详情</a></td>
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