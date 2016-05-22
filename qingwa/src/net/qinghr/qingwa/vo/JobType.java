package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Jobtype entity. @author MyEclipse Persistence Tools
 */

public class JobType implements java.io.Serializable {

	// Fields

	private Integer id;
	private JobType jobType;
	private String title;
	private Integer sort;
	private Boolean isHot;
	private Boolean enable;
	private Set jobSubscribers = new HashSet(0);
	private Set jobTypes = new HashSet(0);
	private Set companyJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public JobType() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
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

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
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

	public Set getJobTypes() {
		return jobTypes;
	}

	public void setJobTypes(Set jobTypes) {
		this.jobTypes = jobTypes;
	}

	public Set getCompanyJobs() {
		return companyJobs;
	}

	public void setCompanyJobs(Set companyJobs) {
		this.companyJobs = companyJobs;
	}

	

}