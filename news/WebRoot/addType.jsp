<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="CSS/addtheme.css" rel="stylesheet" type="text/css" />
  </head>  
  <body>
        <div id="main">
        <form action="doAddType.jsp" method="post" onsubmit="return check()">
    	<div id="header">添加主题</div>
    	<div id="backimg"><img src="Images/opt_name.gif"></img></div>
    	<div id="divbody">
    	<br/>
    		主题名称：<input type="text" id="txtTitle" name="txtType"/><br/>
    		<input type="submit" class="cl" value="提交"/>
    		<input type="reset" class="cl" value="重置"/>
    	</div>
    	</form>
    </div>
  </body>
</html>
