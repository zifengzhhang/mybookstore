<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@include file="/include/base.jsp" %>
</head>
<script type="text/javascript">
	$(function(){
		$(".delBtn").click(function(){
			var td = $(this).parent().parent().children(":first");
			if ( !confirm("确认删除【"+td.text()+"】吗?")){
				//用户点击取消
				return false;
			}
		});
	});
</script>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@include file="/include/book-manager.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>	
			<c:forEach items="${page.pageData }" var="book">
				<tr>
					<td>${book.title }</td>
					<td>${book.price }</td>
					<td>${book.author }</td>
					<td>${book.sales }</td>
					<td>${book.stock }</td>
					<td><a href="manager/BookManagerServlet?method=getBook&id=${book.id }&pn=${page.pageNo }">修改</a></td>
					<td><a class="delBtn" href="manager/BookManagerServlet?method=delete&id=${book.id }&pn=${page.pageNo }">删除</a></td>
				</tr>	
			</c:forEach>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pn=${page.pageNo }">添加图书</a></td>
			</tr>	
		</table>
		<%@include file="/include/page.jsp" %>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>