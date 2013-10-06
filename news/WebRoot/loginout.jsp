<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	//清除session
	//session.invalidate();
	//session.removeAttribute("adminUser");
	session.setAttribute("adminUser",null);

	//清除cookie
	Cookie cookUid=new Cookie("uid",null);
	Cookie cookPwd=new Cookie("pwd",null);
	//设置有效期为过期
	cookUid.setMaxAge(-1);
	cookPwd.setMaxAge(-1);
	//更新cookie为过期后需要覆盖到客户端
	response.addCookie(cookUid);
	response.addCookie(cookPwd);
	
	//response.sendRedirect("index.jsp");
	out.print("<script>alert('退出成功，返回首页');location='index.jsp';</script>");
%>
