package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer sort;
	private Boolean enable;
	private Set resumes = new HashSet(0);
	private Set companyInfos = new HashSet(0);
	private Set jobSubscribers = new HashSet(0);
	private Set companyJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
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

	public Set getResumes() {
		return resumes;
	}

	public void setResumes(Set resumes) {
		this.resumes = resumes;
	}

	public Set getCompanyInfos() {
		return companyInfos;
	}

	public void setCompanyInfos(Set companyInfos) {
		this.companyInfos = companyInfos;
	}

	public Set getJobSubscribers() {
		return jobSubscribers;
	}

	public void setJobSubscribers(Set jobSubscribers) {
		this.jobSubscribers = jobSubscribers;
	}

	public Set getCompanyJobs() {
		return companyJobs;
	}

	public void setCompanyJobs(Set companyJobs) {
		this.companyJobs = companyJobs;
	}


}