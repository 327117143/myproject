package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import dao.NewsTypeDao;
import entity.News;
import entity.NewsType;

/**
 * @author zhongty
 * 描述：新闻类型表接口实现
 * 2011-9-10
 */
public class NewsTypeDaoImpl implements NewsTypeDao {
	
	String sql=null;
	int count=0;
	public int addNewsType(NewsType type) {
		JdbcUtil conn=new JdbcUtil();
		sql="insert into newsType(typeName)values(?)";
		Object []pras={type.getTypeName()};
		count=conn.update(sql, pras);
		return count;
	}
	public List<NewsType> queryAllNewsType() {
		JdbcUtil conn=new JdbcUtil();
		List<NewsType> list=new ArrayList<NewsType>();
		sql="select * from newstype order by typename";
		ResultSet rs=conn.query(sql, null);
		try {
			while(rs.next()){
				NewsType type=new NewsType();
				type.setTypeId(rs.getInt(1));
				type.setTypeName(rs.getString(2));
				list.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			conn.closeAll();
		}
		return list;
	}
	public int getRecordCount() {
		JdbcUtil conn=new JdbcUtil();
		String sql="select count(*) as countnum from newstype";
		ResultSet rs=conn.query(sql, null);
		try {
			while(rs.next()){
				count=rs.getInt("countnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return count;
	}
	public List<NewsType> queryByPage(int page, int size) {
		List<NewsType> list=new ArrayList<NewsType>();
		JdbcUtil conn=new JdbcUtil();
		String sql="select * from (select rownum rn,n.* from newstype n where rownum<=?)where rn>=?";
		Object []pras={page*size,((page-1)*size+1)};
		ResultSet rs=conn.query(sql, pras);
		try {
			while(rs.next()){
				NewsType newsType=new NewsType();
				newsType.setTypeId(rs.getInt("typeid"));
				newsType.setTypeName(rs.getString("typename"));
				list.add(newsType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}

}
