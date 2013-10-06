<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style type="text/css">
    	#divInfo{
    		display: inline;
    	}
    </style>
    <script type="text/javascript">
    	var httpRequest=null;
    	//没有封装ajax的写法
    	function checkUid(oval){
			if(oval==""){
				return;
			}else{
				try {
					httpRequest=new ActiveXobject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						httpRequest=new ActiveXobject("Microsoft.XMLHTTP");
					} catch (e) {
						try {
							httpRequest=new XMLHttpRequest();
							if(httpRequest.overrideMimeType){
								httpRequest.overrideMimeType("text/xml");
							}
						} catch (e) {
						}
					}
				}
				if(httpRequest==null){
					alert("浏览器不支持xmlHttpRequest!");
					return;
				}
				
				httpRequest.open("post", "servletAjax?uid="+oval, true)//与服务器建立连接
				
				//如果使用post方式提交，需要设定文件头
				httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				
				//设置请求过程状态改变时的回调函数
				httpRequest.onreadystatechange=callBack;
				
				//发送数据
				httpRequest.send(null);
			}
			
			//对ajax操作进行封装的方法
			//第一个参数是提交到服务端的网页地址，第二个是回调的函数名,第三个参数是使用post提交方式的数据
			function doAjax(url,rFun,postData){
				try {
					httpRequest=new ActiveXobject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						httpRequest=new ActiveXobject("Microsoft.XMLHTTP");
					} catch (e) {
						try {
							httpRequest=new XMLHttpRequest();
							if(httpRequest.overrideMimeType){
								httpRequest.overrideMimeType("text/xml");
							}
						} catch (e) {
						}
					}
				}
				if(httpRequest==null){
					alert("浏览器不支持xmlHttpRequest!");
					return;
				}
				//设置ajax提交后响应事件所指向的函数
				httpRequest.onreadystatechange=rFun;
				
				httpRequest.open("post", url, true)//与服务器建立连接
				//如果使用post方式提交，需要设定文件头
				httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");

				//需要指定POST提交数据的长度
				httpRequest.setRequestHeader("Content-Length",postData.length);
				
				//发送数据
				httpRequest.send(postData);
			}
			
			function checkUid2(oval){
				alert(oval);
				if(oval==""){
					return;
				}else{
					doAjax("servletAjax",callBack, "uid="+oval)
				}
			}
				
			function callBack(){
				//需要判断当前请求对象的状态是否是4，服务器响应结束
				alert("1="+httpRequest.readyState);
				if(httpRequest.readyState==4){
					//判断Http协议是否是正确返回
					alert("2="+httpRequest.status);
					if(httpRequest.status==200){
						alert("3="+httpRequest.responseText);
						if(httpRequest.responseText=="1"){
							document.getElementById("divInfo").innerHTML="该用户名可用！";
						}else{
							document.getElementById("divInfo").innerHTML="用户名不可用！";
						}
					}else{
						alert("服务请求错误！");
					}
				}
			}
     
    </script>
  </head>  
  <body>
    	用户名：<input type="text" id="txtUid" onblur="checkUid2(this.value)"/><div id="divInfo"></div>
  </body>
</html>
