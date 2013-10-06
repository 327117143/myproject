package entity;

import java.sql.Date;


/**
 * @author zhongty
 *	新闻表
 */
public class News {
	/**
	 * 新闻id
	 */
	private int newsId;
	/**
	 * 新闻类型id
	 */
	private int typeId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 新闻内容
	 */
	private String newsContent;
	/**
	 * 新闻图片url
	 */
	private String imgUrl;
	/**
	 * 标签
	 */
	private String tag;
	/**
	 * 点击数
	 */
	private int clickNum;
	
	public News() {
		super();
	}
	public News(int newsId) {
		super();
		this.newsId = newsId;
	}
	public News(int typeId, String title, Date publishTime,
			String author, String newsContent, String imgUrl, String tag) {
		super();
		this.typeId = typeId;
		this.title = title;
		this.publishTime = publishTime;
		this.author = author;
		this.newsContent = newsContent;
		this.imgUrl = imgUrl;
		this.tag = tag;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getClickNum() {
		return clickNum;
	}
	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	
}
