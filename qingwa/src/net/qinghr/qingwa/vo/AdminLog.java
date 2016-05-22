package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Adminlog entity. @author MyEclipse Persistence Tools
 */

public class AdminLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Admin admin;
	private Timestamp loginTime;
	private String loginIp;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public AdminLog() {
	}
	// Property accessors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


}