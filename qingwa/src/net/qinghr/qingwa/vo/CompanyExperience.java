package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Companyexperience entity. @author MyEclipse Persistence Tools
 */

public class CompanyExperience implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer minTime;
	private Integer maxTime;
	private Boolean enable;
	private Set companyJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public CompanyExperience() {
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

	public Integer getMinTime() {
		return minTime;
	}

	public void setMinTime(Integer minTime) {
		this.minTime = minTime;
	}

	public Integer getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(Integer maxTime) {
		this.maxTime = maxTime;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getCompanyJobs() {
		return companyJobs;
	}

	public void setCompanyJobs(Set companyJobs) {
		this.companyJobs = companyJobs;
	}


}