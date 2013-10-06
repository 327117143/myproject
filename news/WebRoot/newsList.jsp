<%@ page language="java" import="java.util.*,entity.*,dao.*,dao.impl.*"pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>新闻列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<style type="text/css">
body {
	font-size: 12px;
}

.ulItem {
	margin: 0px;
	padding: 0px;
}

#divp {
	float: left;
	bottom：0;
	position：absolute;
}

.ulItem li {
	float: left;
}

.ulItem2 li {
	float: left;
	margin: 0px 0px;
}

#liTitle {
	width: 450px;
}

#liAuthor {
	width: 100px;
	list-style: none;
}

#liTime {
	width: 100px;
	list-style: none;
}

#liControl {
	width: 100px;
	list-style: none;
}
#divp{
	width:100%;
	height:100px;
	position:absolute;
	top:100%;
	margin-top:-50px;
}
</style>
	<script type="text/javascript">

		function goPage(){
			var pageSkip = document.getElementById("txtSkip").value;
			if(pageSkip==""){
				alert("请输入页码");
			}else if(!isNaN(pageSkip)){
				pageSkip=parseInt(pageSkip);
				if(1<=pageSkip && pageSkip<=${requestScope.pageCount}){
					window.location.href="ServletNewsList?pageNum="+pageSkip;
				}else{
					alert("请输入正确页码");
				}
			}else{
				alert("请输入数字");
			} 
		}
	</script>
	</head>
	<body>
		<ul class="ulItem">
			<c:forEach items="${requestScope.newsList}" var="newsList">
				<li id="liTitle">${newsList.title }</li>
				<li id="liAuthor">${newsList.author }</li>
				<li id="liTime">${newsList.publishTime }</li>
				<li id="liControl">
					<a href="NewsServlet?type=update&id=${newsList.newsId }&pageNum=${requestScope.pageNum }">修改</a>
					<a href="NewsServlet?type=delete&id=${newsList.newsId }&pageNum=${requestScope.pageNum }" onclick="return confirm('是否确定删除该数据？')">删除</a>
				</li>
				<br />
				<br />
			</c:forEach>
			
		</ul>
		
		<div id="divp">
			<p align="left">
				当前页：[${requestScope.pageNum }/${requestScope.pageCount }]&nbsp;
				<a href="ServletNewsList?pageNum=1">首页</a>
				<a href="ServletNewsList?pageNum=${requestScope.lastPage }">上一页</a>
				<a href="ServletNewsList?pageNum=${requestScope.nextPage }">下一页</a>
				<a href="ServletNewsList?pageNum=${requestScope.pageCount }">末页</a> 输入页数：
				<input type="text" id="txtSkip" name="txtSkip" size="1" maxlength="5" value="${requestScope.pageNum }"/>
				<a href="#" onClick="goPage()">跳转</a>
			</p>
		</div>
	</body>
</html>
