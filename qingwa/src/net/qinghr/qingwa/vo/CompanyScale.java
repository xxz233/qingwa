package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Companyscale entity. @author MyEclipse Persistence Tools
 */

public class CompanyScale implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer sort;
	private Boolean enable;
	private Set companyInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public CompanyScale() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set getCompanyInfos() {
		return companyInfos;
	}

	public void setCompanyInfos(Set companyInfos) {
		this.companyInfos = companyInfos;
	}

	
}