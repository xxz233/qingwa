package net.qinghr.qingwa.vo;

/**
 * Companyinvestor entity. @author MyEclipse Persistence Tools
 */

public class CompanyInvestor implements java.io.Serializable {

	// Fields

	private Integer id;
	private CompanyStage companyStage;
	private CompanyInfo companyInfo;
	private String title;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public CompanyInvestor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompanyStage getCompanyStage() {
		return companyStage;
	}

	public void setCompanyStage(CompanyStage companyStage) {
		this.companyStage = companyStage;
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	
}