package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Jobcollection entity. @author MyEclipse Persistence Tools
 */

public class JobCollection implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private CompanyJob companyJob;
	private Timestamp inputTime;

	// Constructors

	/** default constructor */
	public JobCollection() {
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

	public CompanyJob getCompanyJob() {
		return companyJob;
	}

	public void setCompanyJob(CompanyJob companyJob) {
		this.companyJob = companyJob;
	}

	public Timestamp getInputTime() {
		return inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

}