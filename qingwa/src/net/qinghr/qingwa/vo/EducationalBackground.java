package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Educationalbackground entity. @author MyEclipse Persistence Tools
 */

public class EducationalBackground implements java.io.Serializable {

	// Fields

	private Integer id;
	private Resume resume;
	private Degree degree;
	private String school;
	private String title;
	private Timestamp startTime;
	private Timestamp endTime;
	private Short enable;

	// Constructors

	/** default constructor */
	public EducationalBackground() {
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
	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Short getEnable() {
		return this.enable;
	}

	public void setEnable(Short enable) {
		this.enable = enable;
	}

}