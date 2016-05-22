package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Resumestatus entity. @author MyEclipse Persistence Tools
 */

public class ResumeStatus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String status;
	private Boolean enable;
	private Set resumeJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public ResumeStatus() {
	}

	/** full constructor */
	public ResumeStatus(String status, Boolean enable, Set resumeJobs) {
		this.status = status;
		this.enable = enable;
		this.resumeJobs = resumeJobs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getResumeJobs() {
		return this.resumeJobs;
	}

	public void setResumeJobs(Set resumeJobs) {
		this.resumeJobs = resumeJobs;
	}

}