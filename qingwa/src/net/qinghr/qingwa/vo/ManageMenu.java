package net.qinghr.qingwa.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Managemenu entity. @author MyEclipse Persistence Tools
 */

public class ManageMenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private ManageMenu manageMenu;
	private String title;
	private Integer sort;
	private String url;
	private String target;
	private Boolean enable;
	private Set manageMenus = new HashSet(0);
	private Set admins = new HashSet(0);

	// Constructors

	/** default constructor */
	public ManageMenu() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ManageMenu getManageMenu() {
		return manageMenu;
	}

	public void setManageMenu(ManageMenu manageMenu) {
		this.manageMenu = manageMenu;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getManageMenus() {
		return manageMenus;
	}

	public void setManageMenus(Set manageMenus) {
		this.manageMenus = manageMenus;
	}

	public Set getAdmins() {
		return admins;
	}

	public void setAdmins(Set admins) {
		this.admins = admins;
	}
}
	