package net.qinghr.qingwa.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Attachmenresume entity. @author MyEclipse Persistence Tools
 */

public class AttachmenResume implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String filePath;
	private Timestamp inputTime;
	private Boolean isDefault;
	private Boolean enable;
	private Set resumeJobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AttachmenResume() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Timestamp getInputTime() {
		return inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getResumeJobs() {
		return resumeJobs;
	}

	public void setResumeJobs(Set resumeJobs) {
		this.resumeJobs = resumeJobs;
	}

	
}