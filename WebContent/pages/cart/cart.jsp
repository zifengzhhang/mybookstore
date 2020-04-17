<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@include file="/include/base.jsp" %>
</head>
<script type="text/javascript">
	$(function(){
		$(".delBtn").click(function(){
			var textEle = $(this).parents("tr").children(":first").text();
			if ( !confirm("确定要删除【"+textEle+"】吗?") ) {
				return false;
			}
		});
		
		$(".amend").change(function(){
			var id = $(this).attr("updateid");
			var count = $(this).val();
			
			$.ajax({
				type : "POST",
				url : "client/CartServlet?method=AjaxUpdate&id="+id+"&count="+count,
				dataType : "JSON",
				success : function(data){
					$("#price_"+id).text(data.totalPrice);
					$("#tiptotalCount").text(data.totalCount);
					$("#tiptotalMoney").text(data.totalMoney);
				}
			});
		});
		
		$("#emptyBtn").click(function(){
			if ( !confirm("确定要清空购物车吗?") ){
				return false;
			}	
		});
		
	});
</script>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@include file="/include/user-info.jsp" %>
	</div>
	
	<div id="main">
	<c:if test="${empty cart.allItems }">
		<div class="cartdiv">
			<h1>购物车为空，<a href="index.jsp">快去商城购买吧</a></h1>	
		</div>
	</c:if>
		<c:if test="${!empty cart.allItems }">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>	
				<c:forEach items="${cart.allItems }" var="item">
					<tr>
						<td>${item.book.title }</td>
						<td><input class="amend" updateid="${item.book.id }" type="text" name="count" value="${item.count }" style="width: 30px;" /></td>
						<td>${item.book.price }</td>
						<td id="price_${item.book.id }">${item.totalPrice }</td>
						<td><a class="delBtn" href="client/CartServlet?method=deleteCart&id=${item.book.id }">删除</a></td>
					</tr>	
				</c:forEach>	
			</table>
			
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count" id="tiptotalCount">${cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price" id="tiptotalMoney">${cart.totalMoney }</span>元</span>
				<span class="cart_span" id="emptyBtn"><a href="client/CartServlet?method=clearCart">清空购物车</a></span>
				<span class="cart_span"><a href="client/OrderClientServlet?method=checkout">去结账</a></span>
			</div>
		</c:if>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>