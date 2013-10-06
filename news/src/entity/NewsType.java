package entity;

/**
 * @author zhongty
 * 新闻类型表
 */
public class NewsType {
	/**
	 * 新闻类型id
	 */
	private int typeId;
	/**
	 * 新闻类型名
	 */
	private String typeName;
	
	
	public NewsType() {
		super();
	}
	public NewsType(int typeId) {
		super();
		this.typeId = typeId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
