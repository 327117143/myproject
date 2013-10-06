<%@ page language="java" import="java.util.*,dao.*,dao.impl.*,entity.*"
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("txtUid");
	String pwd = request.getParameter("txtPwd");
	NewsUserDao dao = new NewsUserDaoImpl();
	NewsUser user = dao.login(uid, pwd);
	if (user != null) {
		//登录成功后，将用户名保存到cookie中
		Cookie cookUid = new Cookie("uid", user.getUserId());
		cookUid.setMaxAge(24 * 60 * 60);
		response.addCookie(cookUid);
		//登录成功后，将密码保存到cookie中
		Cookie cookPwd = new Cookie("pwd", user.getUserPwd());
		cookPwd.setMaxAge(24 * 60 * 60);
		response.addCookie(cookPwd);

		//登录成功后，将用户的状态信息保存到会话对象
		session.setAttribute("adminUser", user);
		//设置会话失效时间
		session.setMaxInactiveInterval(5);
		
		//从application中获取保存所有的在线用户的数据集合
		List<NewsUser> list=(List<NewsUser>)application.getAttribute("userList");
		//判断是否存在，如果不存在，则新建一个存放在线用户的集合对象
		if(list==null){
			list=new ArrayList<NewsUser>();
		}
		//将当前用户添加到集合中
		list.add(user);
		//将集合数据更新到application
		application.setAttribute("userList",list);
		
		out.print("<script>alert('登录成功');location='news_add.jsp';</script>");
		/*request.setAttribute("uid",uid);*/
		/*response.sendRedirect("index.jsp");*/
		//request.getRequestDispatcher("index.jsp").forward(request,response);
	} else {
		out.print("<script>alert('登录失败');location='index.jsp';</script>");
	}
%>