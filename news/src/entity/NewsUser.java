package entity;

/**
 * @author Administrator
 * 用户表
 */
public class NewsUser {
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 用户密码
	 */
	private String userPwd;
	public NewsUser(){}
	public NewsUser(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
}
