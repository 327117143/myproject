package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtil;

import dao.NewsUserDao;
import entity.NewsUser;

/**
 * @author zhongty
 * 描述：用户表接口实现
 * 2011-9-10
 */
public class NewsUserDaoImpl implements NewsUserDao{
	JdbcUtil conn=new JdbcUtil();
	public NewsUser login(String userId, String Pwd) {
		NewsUser user=null;
		System.out.println("用户名："+userId+" 密码："+Pwd);
		ResultSet rs=conn.query("select * from users where userid=? and userpwd=?",userId,Pwd);
		try {
			while(rs.next()){
				user=new NewsUser(rs.getString("userId"), rs.getString("userPwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return user;
	}

}
