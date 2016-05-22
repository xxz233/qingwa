package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Resumejob entity. @author MyEclipse Persistence Tools
 */

public class ResumeJob implements java.io.Serializable {

	// Fields

	private Integer id;
	private Resume resume;
	private CompanyJob companyJob;
	private AttachmenResume attachmenResume;
	private ResumeStatus resumeStatus;
	private Timestamp inputTime;
	private Boolean flag;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public ResumeJob() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public CompanyJob getCompanyJob() {
		return companyJob;
	}

	public void setCompanyJob(CompanyJob companyJob) {
		this.companyJob = companyJob;
	}

	public AttachmenResume getAttachmenResume() {
		return attachmenResume;
	}

	public void setAttachmenResume(AttachmenResume attachmenResume) {
		this.attachmenResume = attachmenResume;
	}

	public ResumeStatus getResumeStatus() {
		return resumeStatus;
	}

	public void setResumeStatus(ResumeStatus resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	public Timestamp getInputTime() {
		return inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
	