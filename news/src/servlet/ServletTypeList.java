package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.NewsTypeBiz;
import biz.impl.NewsTypeBizImpl;

import entity.NewsType;

public class ServletTypeList extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		NewsTypeBiz newsTypeBiz = new NewsTypeBizImpl();
		//分页功能的实现
		int size = 10;//每页记录条数
		int pageNum = 1; //当前第几页
		int pageSkip=1;//跳转到第几页数
		
		if(request.getParameter("txtSkip")!=null){
			pageSkip=Integer.parseInt(request.getParameter("txtSkip"));
		}
		//判断如果是通过分页浏览该页面时
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
			request.setAttribute("pageNum", pageNum);
		}else{
			request.setAttribute("pageNum", 1);
		}
		int totalCount = newsTypeBiz.getRecordCount();//获取总的记录数
		int pageCount = totalCount % size == 0 ? totalCount / size: (totalCount / size + 1);//计算总页数
		
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("pageCount", pageCount);
		
		int lastPage = pageNum == 1 ? 1 : pageNum - 1; //计算上一页
		int nextPage = pageNum == pageCount ? pageCount : pageNum + 1; //计算下一页
		
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("nextPage", nextPage);
		
		List<NewsType> typelist = newsTypeBiz.queryByPage(pageNum, size);
		request.setAttribute("typeList", typelist);
		request.getRequestDispatcher("typeList.jsp").forward(request, response);
	}

}
