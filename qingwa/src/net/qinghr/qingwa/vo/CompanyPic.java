package net.qinghr.qingwa.vo;

/**
 * Companypic entity. @author MyEclipse Persistence Tools
 */

public class CompanyPic implements java.io.Serializable {

	// Fields

	private Integer id;
	private CompanyInfo companyInfo;
	private String title;
	private String pic;

	// Constructors

	/** default constructor */
	public CompanyPic() {
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}