<%@ page language="java" import="java.util.*,entity.*,dao.*,dao.impl.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="CSS/addnews.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/my97/WdatePicker.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/edit/xheditor-1.1.10-zh-cn.min.js"></script>
    
  </head>  
  <body>
    <div id="main">
    <form action="NewsServlet?type=addNews" method="post" onsumit="return check()" enctype="multipart/form-data">
    	<input type="hidden" value="${news.newsId }" name="hdId" id="hdId"/>
    	<input type="hidden" value="${param.pageNum }" name="txtPageNum" id="txtPageNum"/>
    	<div id="header">添加新闻</div>
    	<div id="backimg"><img src="Images/opt_name.gif"></img></div>
    	<div id="divbody">
    	<br/>
    		类型：<select name="selType" id="selType">
    				<option value="">选择类型</option>
    				<c:forEach items="${requestScope.typeList}" var="typeList">
    					<option class="sel" value="${typeList.typeId}" ${typeList.typeId==news.typeId?"selected":"" }>${typeList.typeName }</option>
    				</c:forEach>
    			</select><br/>
    		标题：<input type="text" id="txtTitle" name="txtTitle" value="${news.title }"/><br/>
    		时间：<input type="text" readonly="readonly" id="txtPublishTime" name="txtPublishTime" onclick="WdatePicker();" value="${news.publishTime }"/><br/>
    		作者：<input type="text" id="txtAuthor" name="txtAuthor" value="${news.author }"/><br/>
    		摘要：<input type="text" id="txtTag" name="txtTag" value="${news.tag }"/><br/>
    		内容：<textarea id="txtContent" name="txtContent" class="xheditor-mfull" rows=12 cols=85>${news.newsContent }</textarea><br/><br/>
    		上传图片：<input type="file" id="txtUrl" name="txtUrl" value="${news.imgUrl }"/><br/>
    		<input type="submit" class="cl" value='${news==null?"添加新闻":"修改新闻"}'/>
    		<input type="reset" class="cl" value="重置"/>
    	</div>
    </form>
    </div>
  </body>
</html>
