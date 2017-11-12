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
function showOldOrder(history){
	var keywords =document.getElementById("keywords").value;
	if(history!=null){
		if(keywords!=""){
			window.location.href="${pageContext.request.contextPath}/order/orderlist?history="+history+"&keywords="+keywords;
		}else{
			window.location.href="${pageContext.request.contextPath}/order/orderlist?history="+history;
		}
	}
}
</script>
</head>
<body>
<jsp:include page="common/menu.jsp" />
<div id="content" class="wrap">
	<div class="list orderList">
			<table>
				<tr class="title">
					<th class="orderId">订单编号</th>
					<th>商品图片</th>
					<th>商品名称</th>
					<th>商品数量</th>
					<th class="userName">收货人</th>
					<th class="price">订单金额</th>
					<th class="createTime">下单时间</th>
					<th class="status">订单状态</th>
				</tr>
				<c:choose>
						<c:when test="${!empty page and !empty page.records}">
							<c:forEach items="${page.records }" var="ordervo" varStatus="vs">
								<tr class="${vs.index%2==0?'':'odd' }">
									<td>${ordervo.oid }</td>
									<td class="thumb"><img src="${pageContext.request.contextPath }/images/book/${ordervo.image }" /></td>
									<td class="title">${ordervo.bookname }</td>
									<td>${ordervo.count }</td>
									<td>${ordervo.receiver }</td>
									<td>${ordervo.historyBookPrice*ordervo.count }</td>	
									<td>${ordervo.createtime}</td>
									<td>${ordervo.status}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise><tr><td colspan="8">没有搜索到订单</td></tr></c:otherwise>
					</c:choose>
			</table>
			<div class="page-spliter">
				<jsp:include page="common/page.jsp" />
				
				</div>
			<div class="button">
			<input class="input-gray" type="button" value="查看一个月前的订单" onclick="showOldOrder('1M')"/>
			<input class="input-gray" type="button" value="查看一年前的订单" onclick="showOldOrder('1Y')"/>
			</div>
	</div>
</div>
<jsp:include page="common/end.jsp" />
</body>
</html>
