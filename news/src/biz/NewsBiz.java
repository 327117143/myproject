package biz;

import java.util.List;

import entity.News;

/**
 * @author zhongty
 * 描述：新闻数据的业务操作接口
 * 2011-9-12
 */
public interface NewsBiz {
	/**
	 * @return
	 * 描述：处理网站首页要获取的新闻数据
	 */
	public List<News> queryIndexAllNews(int page,int size);
	/**
	 * @return
	 * 描述：获取总记录数
	 */
	public int getRecordCount();
	/**
	 * @param typeId 新闻类型id
	 * @return 新闻数据
	 * 描述：通过新闻类型id查找
	 */
	public List<News> queryNewsByTypeId(int typeId);
	/**
	 * @return list
	 * 描述：查询有图片的新闻
	 */
	public List<News> queryImgNews();
	/**
	 * @param newsid
	 * @return
	 * 描述：根据新闻id查找新闻
	 */
	public News queryNewsById(int newsid);
	/**
	 * @param newsid
	 * @return
	 * 描述：根据新闻id修改新闻
	 */
	public int updateNews(News news);
}
