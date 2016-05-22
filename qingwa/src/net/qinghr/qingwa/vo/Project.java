package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */

public class Project implements java.io.Serializable {

	// Fields

	private Integer id;
	private Resume resume;
	private String title;
	private String job;
	private Timestamp startTime;
	private Timestamp endTime;
	private String direction;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** full constructor */
	public Project(Resume resume, String title, String job,
			Timestamp startTime, Timestamp endTime, String direction,
			Boolean enable) {
		this.resume = resume;
		this.title = title;
		this.job = job;
		this.startTime = startTime;
		this.endTime = endTime;
		this.direction = direction;
		this.enable = enable;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resume getResume() {
		return this.resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}