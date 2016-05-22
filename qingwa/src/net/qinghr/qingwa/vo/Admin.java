package net.qinghr.qingwa.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String password;
	private Timestamp loginTime;
	private String loginIp;
	private Boolean isSuper;
	private Timestamp inputTime;
	private Integer count;
	private Boolean enable;
	private Set adminLogs = new HashSet(0);
	private Set manageMenus = new HashSet(0);
	private Set articles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
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

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Boolean getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(Boolean isSuper) {
		this.isSuper = isSuper;
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getAdminLogs() {
		return adminLogs;
	}

	public void setAdminLogs(Set adminLogs) {
		this.adminLogs = adminLogs;
	}

	public Set getManageMenus() {
		return manageMenus;
	}

	public void setManageMenus(Set manageMenus) {
		this.manageMenus = manageMenus;
	}

	public Set getArticles() {
		return articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

	// Property accessors
	
}