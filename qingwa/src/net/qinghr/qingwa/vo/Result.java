package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Result entity. @author MyEclipse Persistence Tools
 */

public class Result implements java.io.Serializable {

	// Fields

	private Integer id;
	private Resume resume;
	private String url;
	private String direction;
	private Timestamp inputTime;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public Result() {
	}

	/** full constructor */
	public Result(Resume resume, String url, String direction,
			Timestamp inputTime, Boolean enable) {
		this.resume = resume;
		this.url = url;
		this.direction = direction;
		this.inputTime = inputTime;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Timestamp getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}