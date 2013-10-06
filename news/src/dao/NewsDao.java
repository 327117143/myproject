package dao;

import java.util.List;

import entity.News;

/**
 * @author zhongty
 * 描述：新闻表数据操作接口
 * 2011-9-10
 */
public interface NewsDao {
	/**
	 * @param news
	 * @return 操作行数
	 * 描述：添加新闻
	 */
	public int addNews(News news);
	/**
	 * @return 结果集合
	 * 描述：查询所有新闻
	 */
	public List<News> queryAllNews();
	
	
	/**
	 * @param typeId 新闻类型id
	 * @return 新闻数据list
	 * 描述：通过新闻类型id查找
	 */
	public List<News> queryNewsByTypeId(int typeId);
	/**
	 * @param newid
	 * @return 操作影响行数
	 * 描述：通过id删除新闻
	 */
	public int deleteNews(int newsid);
	/**
	 * @param page 当前第几页
	 * @param size 每页显示条数
	 * @return list
	 * 描述：分页获取数据
	 */
	public List<News> queryByPage(int page,int size);
	/**
	 * @return
	 * 描述：获取总记录数
	 */
	public int getRecordCount();
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
