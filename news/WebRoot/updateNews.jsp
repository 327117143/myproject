<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="CSS/addnews.css" rel="stylesheet" type="text/css" />
  </head>  
  <body>
    <div id="main">
    	<div id="header">编辑新闻</div>
    	<div id="backimg"><img src="Images/opt_name.gif"></img></div>
    	<div id="divbody">
    	<br/>
    		主题：<select>
    				<option>选择</option>
    			</select><br/>
    		标题：<input type="text" id="titler"/><br/>
    		作者：<input type="text" id="author"/><br/>
    		摘要：<textarea id="about" rows="2px" cols="40px"></textarea><br/>
    		内容：<textarea id="content" rows="6px" cols="60px"></textarea><br/><br/>
    		上传图片：<input type="file"/><br/>
    		<input type="submit" class="cl" value="提交"/>
    		<input type="reset" class="cl" value="重置"/>
    	</div>
    </div>
  </body>
</html>
