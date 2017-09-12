<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css" />
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">杭州汇道网上书城</div>
		<div id="navbar">
			<div class="userMenu">
				<ul>
					<li class="current"><a
						href="${pageContext.request.contextPath }/某个ＳＥＲＶＬＥＴ">User首页</a></li>
					<li><a href="orderlist.html">我的订单</a></li>
					<li><a href="shopping.html">购物车</a></li>
					<li><a href="#">注销</a></li>
				</ul>
			</div>
			<form method="get" name="search" action="">
				搜索：<input class="input-text" type="text" name="keywords" /><input
					class="input-btn" type="submit" name="submit" value="" />
			</form>
		</div>
	</div>
	<div id="content" class="wrap">
		<div class="list bookList">
			<form method="post" name="shoping" action="shopping.html">
				<table>
					<tr class="title">
						<th class="checker"></th>
						<th>书名</th>
						<th class="price">价格</th>
						<th class="store">库存</th>
						<th class="view">图片预览</th>
					</tr>
					<c:choose>
						<c:when test="${!empty page }">
							<c:forEach items="${page.records }" var="book" varStatus="vs">
								<tr class="${vs.index%2==0?'':'odd' }">
									<td><input type="checkbox" name="bookId" value="${book.bid }" /></td>
									<td class="title">${book.bookname }</td>
									<td>￥${book.price }</td>
									<td>${book.stock}</td>
									<td class="thumb"><img src="${book.image }" /></td>
								</tr>
							</c:forEach>

						</c:when>
						<c:otherwise>
						
						没有椒下次来
					
					</c:otherwise>
					</c:choose>


				</table>
				<div class="page-spliter">
				<jsp:include page="page.jsp" />
				<%-- <%@ include file="page.jsp" %> --%>
					<!-- <a href="">&lt;</a> <a href="#">首页</a> <span class="current">1</span>
					<a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <span>...</span>
					<a href="#">尾页</a> <a href="#">&gt;</a> -->
				</div>
				<div class="button">
					<input class="input-btn" type="submit" name="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">杭州汇道网上书城 &copy; 版权所有</div>
</body>
</html>
