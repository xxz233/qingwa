package net.qinghr.qingwa.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String password;
	private String userName;
	private Boolean type;
	private Timestamp inputTime;
	private Integer count;
	private String loginIp;
	private Timestamp loginTime;
	private String code;
	private Boolean isValidate;
	private Boolean enable;
	private Set jobSubscribers = new HashSet(0);
	private Set companyInfos = new HashSet(0);
	private Set userProtectQuestions = new HashSet(0);
	private Set jobCollections = new HashSet(0);
	private Set resumes = new HashSet(0);
	private Set attachmenResumes = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Timestamp getInputTime() {
		return inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(Boolean isValidate) {
		this.isValidate = isValidate;
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

	public Set getCompanyInfos() {
		return companyInfos;
	}

	public void setCompanyInfos(Set companyInfos) {
		this.companyInfos = companyInfos;
	}

	public Set getUserProtectQuestions() {
		return userProtectQuestions;
	}

	public void setUserProtectQuestions(Set userProtectQuestions) {
		this.userProtectQuestions = userProtectQuestions;
	}

	public Set getJobCollections() {
		return jobCollections;
	}

	public void setJobCollections(Set jobCollections) {
		this.jobCollections = jobCollections;
	}

	public Set getResumes() {
		return resumes;
	}

	public void setResumes(Set resumes) {
		this.resumes = resumes;
	}

	public Set getAttachmenResumes() {
		return attachmenResumes;
	}

	public void setAttachmenResumes(Set attachmenResumes) {
		this.attachmenResumes = attachmenResumes;
	}

}