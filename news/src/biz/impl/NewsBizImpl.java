package biz.impl;

import java.util.List;

import biz.NewsBiz;
import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import entity.News;

/**
 * @author zhongty
 * 描述：新闻数据的业务操作接口实现
 * 2011-9-12
 */
public class NewsBizImpl implements NewsBiz {

	public List<News> queryIndexAllNews(int page,int size) {
		NewsDao dao= new NewsDaoImpl();
		return dao.queryByPage(page, size);
	}

	public int getRecordCount() {
		NewsDao dao= new NewsDaoImpl();
		return dao.getRecordCount();
	}

	public List<News> queryNewsByTypeId(int typeId) {
		NewsDao dao= new NewsDaoImpl();
		return dao.queryNewsByTypeId(typeId);
	}

	public List<News> queryImgNews() {
		NewsDao dao= new NewsDaoImpl();
		return dao.queryImgNews();
	}

	public News queryNewsById(int newsid) {
		NewsDao dao= new NewsDaoImpl();
		return dao.queryNewsById(newsid);
	}

	public int updateNews(News news) {
		NewsDao dao= new NewsDaoImpl();
		return dao.updateNews(news);
	}

}
