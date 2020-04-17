<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@include file="/include/base.jsp" %>
</head>
<script type="text/javascript">
	$(function(){
		$(".addBtn").click(function(){
			var bookid = $(this).attr("updateId");
			
			$.ajax({
				type : "POST",
				url : "client/CartServlet?method=AjaxaddCart&id="+bookid,
				dataType : "JSON",
				success : function(data){
					$("#tiptotalCount").text(data.totalCount);
					$("#tiptitle").css("color", "blue");
					$("#tiptitle").text("你刚刚将【"+data.title+"】加入了购物车");
				}
			});
		});
		
	});
</script>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@include file="/include/user-info.jsp" %>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/BookClientServlet?method=pageByPrice" method="post">
					价格：<input id="min" type="text" name="min" value="${param.min }"> 元 - 
						<input id="max" type="text" name="max" value="${param.max }"> 元 
						<input name="pn" type="hidden" value="1" />
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				您的购物车中有<span id="tiptotalCount"><c:out value="${cart.totalCount }" default="0"></c:out></span>件商品
				<div>
					<span id="tiptitle">&nbsp;</span>
				</div>
			</div>
			<c:forEach items="${page.pageData }" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath }" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.title }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock }</span>
						</div>
						<div class="book_add">
							<button class="addBtn" updateId="${book.id }">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
			
		</div>
		<%@include file="/include/page.jsp" %>	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>