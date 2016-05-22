package net.qinghr.qingwa.vo;

/**
 * Companypreparedlabel entity. @author MyEclipse Persistence Tools
 */

public class CompanyPreparedLabel implements java.io.Serializable {

	// Fields

	private String title;
	private Integer sort;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public CompanyPreparedLabel() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	

}