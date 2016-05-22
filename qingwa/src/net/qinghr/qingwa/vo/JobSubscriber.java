package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Jobsubscriber entity. @author MyEclipse Persistence Tools
 */

public class JobSubscriber implements java.io.Serializable {

	// Fields

	private Integer id;
	private Area area;
	private JobType jobType;
	private PersonalSalary personalSalary;
	private Industry industry;
	private CompanyStage companyStage;
	private User user;
	private String email;
	private Integer cycle;
	private Timestamp nextSendTime;
	private Timestamp inputTime;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public JobSubscriber() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public PersonalSalary getPersonalSalary() {
		return personalSalary;
	}

	public void setPersonalSalary(PersonalSalary personalSalary) {
		this.personalSalary = personalSalary;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public CompanyStage getCompanyStage() {
		return companyStage;
	}

	public void setCompanyStage(CompanyStage companyStage) {
		this.companyStage = companyStage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Timestamp getNextSendTime() {
		return nextSendTime;
	}

	public void setNextSendTime(Timestamp nextSendTime) {
		this.nextSendTime = nextSendTime;
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