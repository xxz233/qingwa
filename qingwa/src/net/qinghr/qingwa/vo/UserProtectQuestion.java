package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Userprotectquestion entity. @author MyEclipse Persistence Tools
 */

public class UserProtectQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private ProtectQuestion protectQuestion;
	private User user;
	private String answer;
	private Timestamp inputTime;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public UserProtectQuestion() {
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public ProtectQuestion getProtectQuestion() {
		return protectQuestion;
	}

	public void setProtectQuestion(ProtectQuestion protectQuestion) {
		this.protectQuestion = protectQuestion;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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