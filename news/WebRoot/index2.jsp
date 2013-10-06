<%@ page language="java" import="java.util.*,entity.*,biz.*,biz.impl.*"pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/MyPage.tld" prefix="pt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新闻中国</title>
<link href="CSS/main.css" rel="stylesheet" type="text/css" />
<script src="js/form.js"></script>
</head>
<body>
<div id="header">
  <div id="top_login">
  <form action="doLogin.jsp" method="post" onsubmit="return check()">
    <label> 登录名 </label>
    <input type="text" id="txtUid" name="txtUid" value="" class="login_input" />
    <label> 密&#160;&#160;码 </label>
    <input type="password" id="txtPwd" name="txtPwd" value="" class="login_input" />
    <input type="submit" class="login_sub" value="登录"/>
    </form>
    <label id="error"> </label>
    <img src="Images/friend_logo.gif" alt="Google" id="friend_logo" /> 
    </div>
  <div id="nav">
    <div id="logo"> <img src="Images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="Images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<%
	NewsBiz newsBiz=new NewsBizImpl();
	List<News> nlist1=newsBiz.queryNewsByTypeId(25);
	List<News> nlist2=newsBiz.queryNewsByTypeId(25);
	List<News> nlist3=newsBiz.queryNewsByTypeId(26);
%>
<div id="container">
  <div class="sidebar">
    <h1> <img src="Images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
      <c:forEach items="${requestScope.nlist1}" var="nlist1">
      	 <li> <a href='index?id=${nlist1.newsId}'><b> ${nlist1.title}</b></a> </li>
      </c:forEach>
      </ul>
    </div>
    <h1> <img src="Images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
      <c:forEach items="${requestScope.nlist2}" var="nlist2">
      	 <li> <a href='index?id=${nlist2.newsId}'><b> ${nlist2.title} </b></a> </li>
      </c:forEach>
      </ul>
    </div>
    <h1> <img src="Images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      <c:forEach items="${requestScope.nlist3}" var="nlist3">
      	 <li> <a href='index?id=${nlist3.newsId}'><b> ${nlist3.title} </b></a> </li>
      </c:forEach>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
        <li id='class_month'>
        <c:forEach items="${requestScope.tlist}" var="tlist">
      	  <a href='#' value="${tlist.typeId}"><b>${tlist.typeName}</b></a>
        </c:forEach>
         
         </li>
      </ul>
      <ul class="classlist">
      <c:forEach items="${requestScope.nlist}" var="nlist" varStatus="itmesState">
      <li id="liTitle">${nlist.title }<span>${nlist.publishTime }</span></li>
      	<c:if test="${(itmesState.index+1)%5==0}">
      		<li class="space"></li>
      	</c:if>
      </c:forEach>
			
        <p align="right"><pt:page pageIndex="${param.page}" url="index?" pageMax="${requestScope.pageCount}"/></p>
      </ul>
    </div>
    <div class="picnews">
      <ul>
      <c:forEach items="${requestScope.imglist}" var="imglist">
      	<li> <a href="#"><img src="upload/${imglist.imgUrl }" width="249" height="240"alt="" /> </a><a href="#">${imglist.title }</a> </li>
      </c:forEach>
      </ul>
    </div>
  </div>
</div>
<div id="friend">
  <h1 class="friend_t"> <img src="Images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
    文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    新闻中国 版权所有 &nbsp;&nbsp;在线人数：
  <%
  	//先从application中获取在线用户的数据
  	List<NewsUser> list=(List<NewsUser>)application.getAttribute("userList");
    int onlineCount=0;
    if(list!=null){
    	onlineCount=list.size();
    }
  %>
  <%=onlineCount %>人</p>
</div>
</body>
</html>
