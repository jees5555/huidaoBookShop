<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="header" class="wrap">
	<div id="logo">杭州汇道网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li class="current"><a href="${pageContext.request.contextPath }/showbooks">首页</a></li>
					<li><a href="orderlist">我的订单</a></li>
					<li><a href="cartlist">购物车</a></li>
					<li><a href="${pageContext.request.contextPath}/">注销</a></li>
					<li>${sessionScope.username}，欢迎光临汇道网上书城</li>
			</ul>
		</div>
		&nbsp;
	</div>
</div>