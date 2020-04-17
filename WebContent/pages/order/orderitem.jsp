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
				<td>书名</td>
				<td>数量</td>
				<td>单价</td>
				<td>总价</td>
				<td>订单号</td>
			</tr>		
			<c:forEach items="${allOrderItem }" var="oItem">
				<tr>
					<td>${oItem.title }</td>
					<td>${oItem.count }</td>
					<td>${oItem.price }</td>
					<td>${oItem.totalPrice }</td>
					<td>${oItem.orderId }</td>
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