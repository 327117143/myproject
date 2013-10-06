package biz;

import java.util.List;

import entity.NewsType;

/**
 * @author zhongty
 * 描述：新闻类型业务接口
 * 2011-9-12
 */
public interface NewsTypeBiz {
	/**
	 * @return
	 * 描述：处理首页新闻主题显示
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
