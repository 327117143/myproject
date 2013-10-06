package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.FileUp;
import util.RenamePolicyCos;

import com.oreilly.servlet.MultipartRequest;

import biz.NewsBiz;
import biz.impl.NewsBizImpl;

import dao.NewsDao;
import dao.NewsTypeDao;
import dao.impl.NewsDaoImpl;
import dao.impl.NewsTypeDaoImpl;
import entity.News;
import entity.NewsType;

public class NewsServlet extends HttpServlet {

	NewsDao dao = new NewsDaoImpl();
	NewsBiz newsBiz=new NewsBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		processRequest(request, response);
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 描述：处理各种请求，跳转到相应的servlet处理方法中
	 */
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");
		//接收类型参数
		String type=request.getParameter("type");
		if(type!=null){
			if(type.equals("delete")){
				deleteNews(request, response);
//				paging(request, response);
			}
			if(type.equals("update")){
				updateNews(request, response);
//				paging(request, response);
			}
			if(type.equals("typeSelect")){
				typeSelect(request, response);
			}
			if(type.equals("addNews")){
				addNews(request, response);
			}
		}
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 描述：查找新闻
	 */
	public void newsList(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		response.setContentType("text/html");
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 描述：删除新闻
	 */
	public void deleteNews(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int newsid=Integer.valueOf(request.getParameter("id"));
		if(dao.deleteNews(newsid)<=0){
			//如果删除失败
			out.print("<script>alert('删除失败');history.go(-1);</script>");
			return;
		}else{
			out.print("<script>alert('删除成功');location='PageServlet?pageNum="+request.getParameter("pageNum")+"';</script>");
		}
		out.flush();
		out.close();
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 描述：更新新闻
	 */
	public void updateNews(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int newsid=Integer.valueOf(request.getParameter("id"));
		News news=newsBiz.queryNewsById(newsid);
		if(news==null){
			out.print("<script>alert('不存在的新闻数据！');history.go(-1);</script>");
			return;
		}
		//将新闻数据保存到请求对象中
		request.setAttribute("news", news);
		
		NewsTypeDao typeDao=new NewsTypeDaoImpl();
	  	List<NewsType> typelist=typeDao.queryAllNewsType();
	  	request.setAttribute("typeList", typelist);
		//转发
		request.getRequestDispatcher("addNews.jsp?pageNum="+request.getParameter("pageNum")).forward(request, response);
		out.flush();
		out.close();
		return;
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 描述：添加新闻
	 */
	public void addNews(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//设定当前文件上传的目标文件夹
		String savePath=request.getRealPath("/upload");
		//设定文件上传的最多容量
		int maxSize=10*10*1024*1024;
		//创建文件上传请求域对象
		MultipartRequest req=new MultipartRequest(request,savePath,maxSize,"utf-8",new RenamePolicyCos());
		int typeId = Integer.parseInt(req.getParameter("selType"));
		
		String hdId=req.getParameter("hdId");
		String title = req.getParameter("txtTitle");
		
		String publishTime =req.getParameter("txtPublishTime");
		System.out.println("发布时间："+publishTime);
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date uDate = null;
		try {
			uDate = sdf.parse(publishTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date date=new java.sql.Date(uDate.getTime());
		
		String author = req.getParameter("txtAuthor");
		String tag = req.getParameter("txtTag");
		String newsContent = req.getParameter("txtContent");
		//上传文件
		String imgUrl = null;
		try {
			imgUrl = FileUp.uploadfiles(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		NewsDao dao=new NewsDaoImpl();
		NewsBiz biz=new NewsBizImpl();
		News news=new News(typeId,title,date,author,newsContent,imgUrl,tag);
		//判断隐藏域中新闻id是否为空值，如果为空表示添加操作，否则是修改
		if(hdId.equals("")){
			int count=dao.addNews(news);
			if(count>0){
				out.print("<script>alert('添加成功');location='NewsServlet?type=typeSelect';</script>");
			}else{	
				out.print("<script>alert('添加失败');history.go(-1);</script>");
			}
		}else{
			news.setNewsId(Integer.valueOf(hdId));
			if(biz.updateNews(news)>0){
				out.print("<script>alert('修改成功');location='PageServlet?pageNum="+req.getParameter("txtPageNum")+"';</script>");
			}else{	
				out.print("<script>alert('修改失败');history.go(-1);</script>");
			}
		}
		
		
		
		out.flush();
		out.close();
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 描述：进入修改页面时，选择框数据为选定
	 */
	public void typeSelect(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		NewsTypeDao typeDao=new NewsTypeDaoImpl();
	  	List<NewsType> typelist=typeDao.queryAllNewsType();
	  	request.setAttribute("typeList", typelist);
		//转发
		request.getRequestDispatcher("addNews.jsp").forward(request, response);
		return;
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 描述：分页
	 */
	public void paging(HttpServletRequest request, HttpServletResponse response)
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
}
