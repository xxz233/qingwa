package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Industry entity. @author MyEclipse Persistence Tools
 */

public class Industry implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer sort;
	private Boolean enable;
	private Set jobSubscribers = new HashSet(0);
	private Set companyInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Industry() {
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

	public Set getJobSubscribers() {
		return jobSubscribers;
	}

	public void setJobSubscribers(Set jobSubscribers) {
		this.jobSubscribers = jobSubscribers;
	}

	public Set getCompanyInfos() {
		return companyInfos;
	}

	public void setCompanyInfos(Set companyInfos) {
		this.companyInfos = companyInfos;
	}


}