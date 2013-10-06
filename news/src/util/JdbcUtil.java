package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author zhongty
 *描述：
 * 2013-9-7
 */
public class JdbcUtil {
	/**
	 * 字段：驱动程序
	 *//*
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	*//**
	 * 字段：数据库连接字符串
	 *//*
	private static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	*//**
	 * 字段：数据库用户名
	 *//*
	private static final String USER="news";
	*//**
	 * 字段：密码
	 *//*
	private static final String PWD="news";*/
	
	/**
	 * 字段：声明连接
	 */
	private Connection conn;
	/**
	 * 字段：声明预处理语句对象
	 */
	private PreparedStatement ps;
	/**
	 * 字段：声明结果集对象
	 */
	private ResultSet rs;

	private static DataSource source=null;
	
	//加载驱动程序
	/*static{
			try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	static{
		//初始化配置文件
		Context ctx;
		try {
			ctx = new InitialContext();
			//使用lookup查找数据源
		    source=(DataSource) ctx.lookup("java:comp/env/jdbc/news");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @return数据库的连接对象
	 * 描述：数据库的连接方法
	 */
	public Connection getConn(){
		try {
//			System.out.println("开始连接。。。");
//			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?user=root&password=root&useUnicode=true&characterEncoding=utf-8");
//			conn=DriverManager.getConnection(URL, USER, PWD);
			//获取数据源连接对象
			conn=source.getConnection();
//			System.out.println("通过数据库连接池取得连接 ");
//			System.out.println("连接成功！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	/**
	 * 
	 * 描述：关闭资源
	 */
	public void closeAll(){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	/**
	 * @param sql更新语句(增、删，改)
	 * @param pras参数数组
	 * @return返回受影响行数
	 */
	public int update(String sql,Object...pras){
		int count=0;	//受影响的行数
		conn=getConn();
		try {
			//创建预编译对象
			ps=conn.prepareStatement(sql);
			//为参数赋值
			if(pras!=null){
				//遍历每个参数进行赋值
				for(int i=0;i<pras.length;i++){
					ps.setObject(i+1, pras[i]);
				}
			}
			count=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return count;
	}
	/**
	 * @param sql查询命令语句
	 * @param pras参数数组
	 * @return返回结果集
	 */
	public ResultSet query(String sql,Object...pras){
		conn=getConn();
		try {
			//创建预编译对象
			ps=conn.prepareStatement(sql);
			if(pras!=null){
				//遍历每个参数进行赋值
				for(int i=0;i<pras.length;i++){
					ps.setObject(i+1, pras[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//此处不要写关闭所有资源
		return rs;
	}
}
