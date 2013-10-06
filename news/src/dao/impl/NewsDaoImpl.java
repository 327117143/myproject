package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import dao.NewsDao;
import entity.News;

/**
 * @author zhongty
 * 描述：新闻表接口实现
 * 2011-9-10
 */
public class NewsDaoImpl implements NewsDao {
	public int addNews(News news) {
		JdbcUtil conn=new JdbcUtil();
		int count=0;
		String sql="insert into news(typeId,title,publishTime,author,newsContent,imgUrl,tag) values(?,?,?,?,?,?,?)";
		Object []pras={news.getTypeId(),news.getTitle(),news.getPublishTime(),news.getAuthor(),news.getNewsContent(),news.getImgUrl(),news.getTag()};
		count=conn.update(sql, pras);
		return count;
	}
	public List<News> queryAllNews() {
		List<News> list=new ArrayList<News>();
		JdbcUtil conn=new JdbcUtil();
		String sql="select * from News order by publishtime";
		ResultSet rs=conn.query(sql, null);
		try {
			while(rs.next()){
				News news=new News();
				news.setNewsId(rs.getInt("newsid"));
				news.setTypeId(rs.getInt("typeid"));
				news.setTitle(rs.getString("title"));
				news.setPublishTime(rs.getDate("publishtime"));
				news.setAuthor(rs.getString("author"));
				news.setNewsContent(rs.getString("newscontent"));
				news.setImgUrl(rs.getString("imgurl"));
				news.setTag(rs.getString("tag"));
				news.setClickNum(rs.getInt("clicknum"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	public int deleteNews(int newsid) {
		int count=0;
		JdbcUtil conn=new JdbcUtil();
		String sql="delete from news where newsid=?";
		Object []pras={newsid};
		count=conn.update(sql, pras);
		return count;
	}
	public List<News> queryByPage(int page, int size) {
		List<News> list=new ArrayList<News>();
		JdbcUtil conn=new JdbcUtil();
		String sql="select * from (select rownum rn,n.* from (select newsid,title,author,publishtime from news order by publishtime desc) n where rownum<=?  )where rn>=?";
		Object []pras={page*size,((page-1)*size+1)};
		ResultSet rs=conn.query(sql, pras);
		try {
			while(rs.next()){
				News news=new News();
				news.setNewsId(rs.getInt("newsid"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setPublishTime(rs.getDate("publishtime"));
				list.add(news);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	public int getRecordCount() {
		JdbcUtil conn=new JdbcUtil();
		String sql="select count(*) as countnum from news";
		ResultSet rs=conn.query(sql, null);
		int count=0;
		try {
			while(rs.next()){
				count=rs.getInt("countnum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return count;
	}
	public List<News> queryNewsByTypeId(int typeId) {
		JdbcUtil conn=new JdbcUtil();
		List<News> list=new ArrayList<News>();
		String sql="select * from news where typeid=? order by publishtime";
		Object []pras={typeId};
		ResultSet rs=conn.query(sql, pras);
		try {
			while(rs.next()){
				News news=new News();
				news.setNewsId(rs.getInt("newsid"));
				news.setTitle(rs.getString("title"));
				list.add(news);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	public List<News> queryImgNews() {
		JdbcUtil conn=new JdbcUtil();
		List<News> list=new ArrayList<News>();
		String sql="select * from news where imgurl is not null and rownum<5";
		ResultSet rs=conn.query(sql, null);
		try {
			while(rs.next()){
				News news=new News();
				news.setNewsId(rs.getInt("newsid"));
				news.setTitle(rs.getString("title"));
				news.setImgUrl(rs.getString("imgurl"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public News queryNewsById(int newsid) {
		JdbcUtil conn=new JdbcUtil();
		News news=new News();
		String sql="select * from news where newsid=?";
		Object []pras={newsid};
		ResultSet rs=conn.query(sql, pras);
		try {
			while(rs.next()){
				news.setNewsId(rs.getInt("newsid"));
				news.setTypeId(rs.getInt("typeid"));
				news.setTitle(rs.getString("title"));
				news.setPublishTime(rs.getDate("publishtime"));
				news.setAuthor(rs.getString("author"));
				news.setNewsContent(rs.getString("newscontent"));
				news.setImgUrl(rs.getString("imgurl"));
				news.setTag(rs.getString("tag"));
				news.setClickNum(rs.getInt("clicknum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}
	public int updateNews(News news) {
		int count=0;
		JdbcUtil conn=new JdbcUtil();
		String sql="update news set typeId=?,title=?,publishTime=?,author=?,newsContent=?,imgUrl=?,tag=? where newsid=?";
		Object []pras={news.getTypeId(),news.getTitle(),news.getPublishTime(),news.getAuthor(),news.getNewsContent(),news.getImgUrl(),news.getTag(),String.valueOf(news.getNewsId())};
		count=conn.update(sql, pras);
		return count;
	}

}
