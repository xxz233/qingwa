package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Current entity. @author MyEclipse Persistence Tools
 */

public class Current implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer sort;
	private Boolean enable;
	private Set resumes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Current() {
	}

	/** full constructor */
	public Current(String title, Integer sort, Boolean enable, Set resumes) {
		this.title = title;
		this.sort = sort;
		this.enable = enable;
		this.resumes = resumes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getResumes() {
		return this.resumes;
	}

	public void setResumes(Set resumes) {
		this.resumes = resumes;
	}

}