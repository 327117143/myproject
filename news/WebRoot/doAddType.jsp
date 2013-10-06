<%@ page language="java" import="java.util.*,entity.*,dao.*,dao.impl.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String newsType=request.getParameter("txtType");
	System.out.println("1:"+newsType);
	
	NewsType type=new NewsType();
	type.setTypeName(newsType);
	System.out.println("2:"+type.getTypeName());
	
	NewsTypeDao dao=new NewsTypeDaoImpl();
	int count=dao.addNewsType(type);
	if(count>0){
		out.print("<script>alert('添加成功');location='addType.jsp';</script>");
	}else{
		out.print("<script>alert('添加失败');location.go(-1);</script>");
	}
%>