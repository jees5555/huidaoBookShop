<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 分页 -->
第${page.pagenum}页/共${page.totalpage}页&nbsp;&nbsp;
<a href="javascript:jump(1);">首页</a>&nbsp;&nbsp;
<a href="javascript:jump(${page.pagenum-1==0?1:page.pagenum-1})">上一页</a>&nbsp;&nbsp;
<c:forEach begin="${page.startPage}" end="${page.endPage}" var="num">
	<a href="javascript:jump(${num})">${num }</a>
</c:forEach>
&nbsp;&nbsp;
<a href="javascript:jump(${page.pagenum+1>page.totalpage?page.totalpage:page.pagenum+1})">下一页</a>&nbsp;&nbsp;
<a href="javascript:jump(${page.totalpage})">尾页</a>
<select id="s1">
	<c:forEach begin="1" end="${page.totalpage}" var="num">
		<option value="${num}" ${page.pagenum==num?'selected="selected"':''}>${num}</option>
	</c:forEach>
</select>
<a href="javascript:jump()">跳转</a>
<script type="text/javascript">
	function jump(num){
	if(num==null){
		num = document.getElementById("s1").value;
	}
	alert(num);
window.location.href="${pageContext.request.contextPath}/${page.servletUrl}?pagenum="+num;
	}
</script>