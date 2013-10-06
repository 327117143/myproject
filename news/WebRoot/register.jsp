<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title>用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>  
  <body>
    <form name="regform" action="" method="post" onsubmit="return check()">
    	<div>
    		用户名：<input type="text" id="txtname" name="txtname"/><br/>
    		输入密码：<input type="password" id="txtpwd" name="txtpwd"/><br/>
    		再次输入密码：<input type="password" id=rtxtpwd" name="rtxtpwd"/><br/>
    		<input type="submit" value="注册"/>
    	</div>
    </form>
  </body>
</html>
