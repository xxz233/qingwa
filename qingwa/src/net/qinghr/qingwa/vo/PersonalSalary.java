package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Personalsalary entity. @author MyEclipse Persistence Tools
 */

public class PersonalSalary implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer minSalary;
	private Integer maxSalary;
	private Boolean enable;
	private Set jobSubscribers = new HashSet(0);

	// Constructors

	/** default constructor */
	public PersonalSalary() {
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

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
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

	
}