package net.qinghr.qingwa.vo;

/**
 * Companyfoundteam entity. @author MyEclipse Persistence Tools
 */

public class CompanyFoundTeam implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer companyId;
	private String title;
	private String job;
	private String direction;
	private String pic;
	private String url;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public CompanyFoundTeam() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	
}