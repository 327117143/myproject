package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import dao.impl.NewsDaoImpl;

import entity.News;

public class PageServlet extends HttpServlet {

	NewsDao dao = new NewsDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//分页功能的实现
		int size = 3;//每页记录条数
		int pageNum = 1; //当前第几页
		int pageSkip=1;//跳转到第几页数
		
		if(request.getParameter("txtSkip")!=null){
			pageSkip=Integer.parseInt(request.getParameter("txtSkip"));
		}
		//判断如果是通过分页浏览该页面时
		if (request.getParameter("pageNum") == null) {
			request.setAttribute("pageNum", 1);
		}else{
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			request.setAttribute("pageNum", pageNum);
		}
		int totalCount = dao.getRecordCount();//获取总的记录数
		int pageCount = totalCount % size == 0 ? totalCount / size: (totalCount / size + 1);//计算总页数
		
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("pageCount", pageCount);
		
		int lastPage = pageNum == 1 ? 1 : pageNum - 1; //计算上一页
		int nextPage = pageNum == pageCount ? pageCount : pageNum + 1; //计算下一页
		
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("nextPage", nextPage);
		
		List<News> list = dao.queryByPage(pageNum, size);
		
		request.setAttribute("newsList", list);
		
		request.getRequestDispatcher("newsList.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}

}
