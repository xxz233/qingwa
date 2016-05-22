package net.qinghr.qingwa.vo;

/**
 * Companylabel entity. @author MyEclipse Persistence Tools
 */

public class CompanyLabel implements java.io.Serializable {

	// Fields

	private Integer id;
	private CompanyInfo companyInfo;
	private String title;

	// Constructors

	/** default constructor */
	public CompanyLabel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}