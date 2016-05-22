package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Companyproduct entity. @author MyEclipse Persistence Tools
 */

public class CompanyProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private CompanyInfo companyInfo;
	private String title;
	private String pic;
	private String url;
	private String direction;
	private Integer sort;
	private Timestamp inputTime;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public CompanyProduct() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Timestamp getInputTime() {
		return inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	

}