<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  	<script type="text/javascript">
		function check(){
			var uid=document.getElementById("txtid");
	  		var pwd=document.getElementById("txtpwd");
	  		if(uid.value==""){
				alert("账号不能为空");
				//uid.select();
				uid.focus();
				return false;
		  	}
		  	if(pwd.value==""){
				alert("密码不能为空");
				pwd.focus();
				return false;
			}
			return true;
		}
		
  		
  	</script>
  </head>  
  <body>
   	<form action="dologin.jsp" method="post" onsubmit="return check()">
   		账号：<input type="text" name="txtid" id="txtid" />
   		<br/>
   		密码：<input type="password" name="txtpwd" id="txtpwd" />
   		<br/>
   		<input type="submit" value="提交"/>
   		<input type="reset" value="重置"/>
   	</form>
  </body>
</html>
