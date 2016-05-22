package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Protectquestion entity. @author MyEclipse Persistence Tools
 */

public class ProtectQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer sort;
	private Boolean enable;
	private Set userProtectQuestions = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProtectQuestion() {
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getUserProtectQuestions() {
		return userProtectQuestions;
	}

	public void setUserProtectQuestions(Set userProtectQuestions) {
		this.userProtectQuestions = userProtectQuestions;
	}

	
}