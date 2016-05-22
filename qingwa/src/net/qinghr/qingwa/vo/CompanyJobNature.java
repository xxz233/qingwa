package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Companyjobnature entity. @author MyEclipse Persistence Tools
 */

public class CompanyJobNature implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer sort;
	private Boolean enable;
	private Set resumes = new HashSet(0);
	private Set companyJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public CompanyJobNature() {
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

	public Set getCompanyJobs() {
		return companyJobs;
	}

	public void setCompanyJobs(Set companyJobs) {
		this.companyJobs = companyJobs;
	}

	
}