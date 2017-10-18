<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript">
window.onload=function (){
	calbookprice();
}

function calbookprice(){
	var bp = document.getElementsByName("bookprice");
	var totalprice=0;
	for(var i = 0; i < bp.length; i++){
    
		totalprice += parseInt(bp[i].innerHTML);
   
	}
	document.getElementById("totalprice").innerHTML=totalprice;
}
</script>
</head>
<body>
<jsp:include page="common/menu.jsp" />
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="docreateorder">
			<table>
				<tr class="title">
					<th class="checker">选择</th>
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
				</tr>
				<c:choose>
						<c:when test="${!empty cartlist }">
							<c:forEach items="${cartlist }" var="cartvo" varStatus="vs">
								<tr class="${vs.index%2==0?'':'odd' }">
									<td><input type="checkbox" name="bid" value="${cartvo.bid }" /></td>
									<td class="thumb"><img src="images/book/${cartvo.image }" /></td>
									<td class="title">${cartvo.bookname }</td>
									<td><input class="input-text" type="text" name="nums" value="${cartvo.count }" /></td>
									<td>￥ <span><a name="bookprice">${cartvo.bookprice}</a></span></td>	
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise><tr><td colspan="5">购物车为空</td></tr></c:otherwise>
					</c:choose>
			</table>
			<div class="button">
				<h4>总价：￥<span><a id="totalprice">65.00</a></span>元&nbsp;&nbsp;<a href="#">从购物车删除</a></h4>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<jsp:include page="common/end.jsp" />
</body>
</html>
