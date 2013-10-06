package dao;

import entity.NewsUser;

/**
 * @author Administrator
 * 用户表的数据操作接口
 */
public interface NewsUserDao {
	/**
	 * @param userId用户名
	 * @param Pwd密码
	 * @return返回查询的对象，NULL值表示未查询到
	 */
	public NewsUser login(String userId,String Pwd);
}
