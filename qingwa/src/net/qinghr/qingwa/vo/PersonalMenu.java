package net.qinghr.qingwa.vo;

/**
 * Personalmenu entity. @author MyEclipse Persistence Tools
 */

public class PersonalMenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String url;
	private String target;
	private Integer sort;
	private Boolean type;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public PersonalMenu() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

}