<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function(){
		$("#gotoPage").click(function(){
			/* alert("${page.pageNo }"); */	
			//获取用户输入的去第几页
			var pn = $("#pn_input").val();
			window.location.href="${page.url }&pn="+pn;
			
		});
	});
</script>
	<div id="page_nav">
		<a href="${page.url }&pn=1">首页</a>
		<c:if test="${page.hasPrev }">
			<a href="${page.url }&pn=${page.pageNo-1 }">上一页</a>
		</c:if>
		<!-- 当前总页码小于等于五时， 显示五页 -->
		<c:if test="${page.totalPage <= 5 }">
			<c:set var="begin" value="1" scope="page"></c:set>
			<c:set var="end" value="${page.totalPage }" scope="page"></c:set>
		</c:if>
		<!-- 当前总页码大于五时 -->
		<c:if test="${page.totalPage > 5 }">
			<!-- 当前页码小于等于三时 -->
			<c:if test="${page.pageNo <= 3 }">
				<c:set var="begin" value="1" scope="page"></c:set>
				<c:set var="end" value="5" scope="page"></c:set>
			</c:if>
			<!-- 当前页码大于三时 -->
			<c:if test="${page.pageNo > 3 }">
				<c:set var="begin" value="${page.pageNo-2 }" scope="page"></c:set>
				<c:set var="end" value="${page.pageNo+2 }" scope="page"></c:set>
			</c:if>
			<!-- 当前页码+2大于等于总页码时 -->
			<c:if test="${page.pageNo+2 >= page.totalPage }">
				<c:set var="begin" value="${page.totalPage-4 }" scope="page"></c:set>
				<c:set var="end" value="${page.totalPage }" scope="page"></c:set>
			</c:if>
		</c:if>
		<c:forEach begin="${begin }" end="${end }" var="pum">
			<c:if test="${pum == page.pageNo }">
				【${pum }】
			</c:if>
			<c:if test="${pum != page.pageNo }">
				<a href="${page.url }&pn=${pum }">${pum }</a>
			</c:if>
		</c:forEach>
		<c:if test="${page.hasNext }">
			<a href="${page.url }&pn=${page.pageNo+1 }">下一页</a>
		</c:if>
		<a href="${page.url }&pn=${page.totalPage }">末页</a>
		共${page.totalPage }页，${page.totalRecord }条记录 到第<input value="${page.pageNo }" name="pn" id="pn_input"/>页
		<input type="button" value="确定" id="gotoPage">
	</div>