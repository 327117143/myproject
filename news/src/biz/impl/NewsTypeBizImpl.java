package biz.impl;

import java.util.List;

import biz.NewsTypeBiz;

import dao.NewsTypeDao;
import dao.impl.NewsTypeDaoImpl;

import entity.NewsType;

/**
 * @author zhongty
 * 描述：新闻类型业务处理接口实现
 * 2011-9-12
 */
public class NewsTypeBizImpl implements NewsTypeBiz {

	public List<NewsType> queryAllNewsType() {
		NewsTypeDao dao=new NewsTypeDaoImpl();
		return dao.queryAllNewsType();
	}

	public List<NewsType> queryByPage(int page, int size) {
		NewsTypeDao dao=new NewsTypeDaoImpl();
		return dao.queryByPage(page, size);
	}

	public int getRecordCount() {
		NewsTypeDao dao=new NewsTypeDaoImpl();
		return dao.getRecordCount();
	}

}
