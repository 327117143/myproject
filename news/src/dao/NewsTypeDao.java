package dao;

import java.util.List;

import entity.News;
import entity.NewsType;

/**
 * @author zhongty
 * 描述：新闻类型表数据操作接口
 * 2011-9-10
 */
public interface NewsTypeDao {
	/**
	 * @param type
	 * @return 操作行
	 * 描述：添加新闻主题
	 */
	public int addNewsType(NewsType type);
	/**
	 * @return 结果集
	 * 描述：查询所有新闻主题
	 */
	public List<NewsType> queryAllNewsType();
	/**
	 * @param page 当前第几页
	 * @param size 每页显示条数
	 * @return list
	 * 描述：分页获取数据
	 */
	public List<NewsType> queryByPage(int page,int size);
	/**
	 * @return
	 * 描述：获取总记录数
	 */
	public int getRecordCount();
}
