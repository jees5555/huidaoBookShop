<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">杭州汇道网上书城</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="login">
	<h2>用户登陆</h2>
	<form method="post" action="showbooks">
		<dl>
			<dt>用户名：</dt>
			<dd><input class="input-text" type="text" name="userName" /><span>当前用户不存在！</span></dd>
			<dt>密　码：</dt>
			<dd><input class="input-text" type="password" name="passWord" /><span>密码过于简单！</span></dd>
			<dt></dt>
			<dd class="button"><input class="input-btn" type="submit" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.html';" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	杭州汇道网上书城 &copy; 版权所有
</div>
</body>
</html>
