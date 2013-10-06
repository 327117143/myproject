package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.NewsBiz;
import biz.NewsTypeBiz;
import biz.impl.NewsBizImpl;
import biz.impl.NewsTypeBizImpl;
import entity.News;
import entity.NewsType;

public class ServletIndex extends HttpServlet {

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
		//left
		NewsBiz newsBiz=new NewsBizImpl();
		List<News> nlist1=newsBiz.queryNewsByTypeId(1);
		List<News> nlist2=newsBiz.queryNewsByTypeId(2);
		List<News> nlist3=newsBiz.queryNewsByTypeId(3);
		
		request.setAttribute("nlist1", nlist1);
		request.setAttribute("nlist2", nlist2);
		request.setAttribute("nlist3", nlist3);
		
		//center typelist
		NewsTypeBiz newsTypeBiz=new NewsTypeBizImpl();
		List<NewsType> tlist=newsTypeBiz.queryAllNewsType();
		request.setAttribute("tlist", tlist);
		
		//分页
		int size = 10;//每页记录条数
		int pageNum = 1; //当前第几页
		//判断如果是通过分页浏览该页面时
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		}
		int totalCount = newsBiz.getRecordCount();//获取总的记录数
		int pageCount = totalCount % size == 0 ? totalCount / size:(totalCount / size + 1);//计算总页数
		//将总页数保存到请求对象中
		request.setAttribute("pageCount", pageCount);
		int count=1;
      	List<News> nlist=newsBiz.queryIndexAllNews(pageNum,size);
      	//将分页保存到请求对象中
      	request.setAttribute("nlist", nlist);
		
      	List<News> imglist=newsBiz.queryImgNews();
      	request.setAttribute("imglist", imglist);
		request.getRequestDispatcher("index2.jsp").forward(request, response);
		
		
	}

}
