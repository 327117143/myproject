<%@ page language="java" import="java.util.*,entity.*,dao.*,dao.impl.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	NewsDao dao=new NewsDaoImpl();
	int count=dao.deleteNews(id);
	if(count>0){
		out.print("<script>alert('删除成功');location='newsList.jsp';</script>");
	}else{
		out.print("<script>alert('删除失败');location.go(-1);</script>");
	}
%>
