<%@ page language="java" import="java.util.*,entity.*,biz.*,biz.impl.*"pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/MyPage.tld" prefix="pt"%>
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
      <%
      	for(News n:nlist1){
      %>
        <li> <a href='#' value="<%=n.getNewsId() %>"><b> <%=n.getTitle() %> </b></a> </li>
        <%
      	}
        %>
      </ul>
    </div>
    <h1> <img src="Images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
        <%
      	for(News n:nlist2){
      %>
        <li> <a href='#' value="<%=n.getNewsId() %>"><b> <%=n.getTitle() %> </b></a> </li>
        <%
      	}
        %>
      </ul>
    </div>
    <h1> <img src="Images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <%
      	for(News n:nlist3){
      %>
        <li> <a href='#' value="<%=n.getNewsId() %>"><b> <%=n.getTitle() %> </b></a> </li>
        <%
      	}
        %>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
    <%
    	NewsTypeBiz newsTypeBiz=new NewsTypeBizImpl();
        	List<NewsType> tlist=newsTypeBiz.queryAllNewsType();
    %>
      <ul class="class_date">
        <li id='class_month'>
        <%
      	for(NewsType type:tlist){
      	%>
         <a href='#' value="<%=type.getTypeId() %>"><b><%=type.getTypeName() %> </b></a>
        <%
      	}
        %>
         </li>
      </ul>
      <%
      	int size = 10;//每页记录条数
		int pageNum = 1; //当前第几页
		//判断如果是通过分页浏览该页面时
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
			System.out.println(pageNum);
		}
		int totalCount = newsBiz.getRecordCount();//获取总的记录数
		int pageCount = totalCount % size == 0 ? totalCount / size:(totalCount / size + 1);//计算总页数

		int count=1;
      	List<News> nlist=newsBiz.queryIndexAllNews(pageNum,size);
      %>
      <ul class="classlist">
       <%
			for (News news : nlist) {
		%>
			<li id="liTitle"><%=news.getTitle() %><span><%=news.getPublishTime() %></span></li>
		<%if(count%5==0){ %>
        <li class="space"></li>
        	
        <%
        }
        count++;
        }
      	%>
        <p align="right"><pt:page pageIndex="<%=pageNum %>" url="index.jsp?" pageMax="<%=pageCount %>"/></p>
      </ul>
    </div>
    <%
    	nlist=newsBiz.queryImgNews();
    %>
    <div class="picnews">
      <ul>
      <%
      	for(News n:nlist){
      %>
        <li> <a href="#"><img src="upload/<%=n.getImgUrl() %>" width="249" height="24	0"alt="" /> </a><a href="#"><%=n.getTitle() %></a> </li>
        <%
      	}
        %>
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
