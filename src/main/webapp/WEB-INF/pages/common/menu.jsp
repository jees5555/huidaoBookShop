<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="header" class="wrap">
	<div id="logo">杭州汇道网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li ${model=="showbooks"?"class='current'":""} ><a href="${pageContext.request.contextPath }/showbooks">首页</a></li>
				<li ${model=="orderlist"?"class='current'":""} ><a href="orderlist">我的订单</a></li>
				<li ${model=="cartlist"?"class='current'":""} ><a href="${pageContext.request.contextPath }/cart/cartlist">购物车</a></li>
				<li><a href="${pageContext.request.contextPath}/">注销</a></li>
					<li>${sessionScope.username}，欢迎光临汇道网上书城</li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input id="keywords" class="input-text" type="text" name="keywords" value="${keywords}"/>
			<input class="input-btn" type="submit" name="" value="" />
		</form>
	</div>
</div>