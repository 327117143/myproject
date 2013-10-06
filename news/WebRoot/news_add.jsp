<%@ page language="java" import="java.util.*,entity.*,dao.*,dao.impl.*"
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	NewsUser user = (NewsUser) session.getAttribute("adminUser");
	String uid = null;
	String pwd = null;
	//判断用户是否登录
	if (user == null) {
		//session中无会话登录信息，从cookie中获取
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (c.getName().equals("uid")) {
					//获取用户名
					uid = c.getValue();
				} else if (c.getName().equals("pwd")) {
					//获取密码
					pwd = c.getValue();
				}
			}
			//判断是否从cookie中获取到用户名和密码的值
			if (uid != null && pwd != null) {
				NewsUserDao userDao = new NewsUserDaoImpl();
				//将用户名和密码传到数据访问层查询
				user = userDao.login(uid, pwd);
				//如果查询到数据，表示登录成功
				if (user != null) {
					//将用户数据保存到session
					System.out.println("会话不存在，从cookie中登录成功");
					session.setAttribute("adminUser", user);
				}
			}
		}
		// 如果cookie中不存在用户名和密码，或是使用cookie中的用户名和密码无法正常登录，则表示用户尚未登录
		if (user == null) {
			System.out.println("会话,cookie都不存在，登录失败！！");
			out.print("<script>alert('你尚未登录，请先登录');location='index.jsp';</script>");
			return;
		}
	} else {
		System.out.println("会话存在，登录成功");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="CSS/news_add.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="divHead">
			<div id="divWelcome">
				欢迎使用新闻管理系统！
			</div>
			<div id="divHImg">
				<div id="logo">
					<img src="Images/logo.jpg" />
				</div>
				<div id="a_b">
					<img src="Images/a_b01.gif" />
				</div>
			</div>
		</div>
		<div id="adm">
			<div id="status">
				管理员：<%=user.getUserId()%>登录&nbsp;&nbsp;&nbsp;
				<a href="loginout.jsp">login out</a>
			</div>
		</div>
		<div id="divList">
			<ul>
				<li>
					<a href="NewsServlet?type=typeSelect" target="ifra">添加新闻</a>
				</li>
				<li>
					<a href="NewsServlet?type=update" target="ifra">编辑新闻</a>
				</li>
				<li>
					<a href="searchNews.jsp" target="ifra">查找新闻</a>
				</li>
				<li>
					<a href="addType.jsp" target="ifra">添加主题</a>
				</li>
				<li>
					<a href="ServletTypeList" target="ifra">编辑主题</a>
				</li>
			</ul>
		</div>
		<div id="divIframe">
			<iframe id="ifra" name="ifra" src="NewsServlet?type=typeSelect" frameborder="no"
				scrolling="no" width="780px" height="540px" ></iframe>
		</div>
		<div id="divBottom">
			<div id="about">
				<a href="#">联系我们</a><span>|</span>
				<a href="#">广告服务</a><span>|</span>
				<a href="#">供稿服务</a><span>|</span><a href="#">法律声明</a><span>|</span>
				<a href="#">招聘信息</a><span>|</span>
				<a href="#">网站地图</a><span>|</span>
				<a href="#">留言反馈</a>
			</div>
			<div id="footer">
				<p class="">
					24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160;
					<a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888
					<br />
					文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱：
					<a href="#">jubao@jb-aptech.com.cn</a>
				</p>
				<p class="copyright">
					Copyright &copy; 1999-2009 News China gov, All Right Reserver
					<br />
					新闻中国 版权所有 &nbsp;&nbsp;在线人数：
  <%
  	//先从application中获取在线用户的数据
  	List<NewsUser> list=(List<NewsUser>)application.getAttribute("userList");
    int onlineCount=0;
    if(list!=null){
    	onlineCount=list.size();
    }
  %>
  <%=onlineCount %>人
				</p>
			</div>
		</div>
	</body>
</html>
