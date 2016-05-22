package net.qinghr.qingwa.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Companyjob entity. @author MyEclipse Persistence Tools
 */

public class CompanyJob implements java.io.Serializable {

	// Fields

	private Integer id;
	private Area area;
	private JobType jobType;
	private CompanyJobNature companyJobNature;
	private Degree degree;
	private CompanyExperience companyExperience;
	private CompanyInfo companyInfo;
	private String title;
	private String department;
	private Integer minSalary;
	private Integer maxSalary;
	private String direction;
	private Integer view;
	private Integer resumeCount;
	private Timestamp editTime;
	private Timestamp inputTime;
	private Timestamp refreshTime;
	private Boolean isDown;
	private Boolean isValidate;
	private String adress;
	private Float longitude;
	private Float latitude;
	private Boolean enable;
	private Set resumeJobs = new HashSet(0);
	private Set jobCollections = new HashSet(0);

	// Constructors

	/** default constructor */
	public CompanyJob() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public CompanyJobNature getCompanyJobNature() {
		return companyJobNature;
	}

	public void setCompanyJobNature(CompanyJobNature companyJobNature) {
		this.companyJobNature = companyJobNature;
	}
	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public CompanyExperience getCompanyExperience() {
		return companyExperience;
	}

	public void setCompanyExperience(CompanyExperience companyExperience) {
		this.companyExperience = companyExperience;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getResumeCount() {
		return resumeCount;
	}

	public void setResumeCount(Integer resumeCount) {
		this.resumeCount = resumeCount;
	}

	public Timestamp getEditTime() {
		return editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

	public Timestamp getInputTime() {
		return inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public Timestamp getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(Timestamp refreshTime) {
		this.refreshTime = refreshTime;
	}

	public Boolean getIsDown() {
		return isDown;
	}

	public void setIsDown(Boolean isDown) {
		this.isDown = isDown;
	}

	public Boolean getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(Boolean isValidate) {
		this.isValidate = isValidate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set getResumeJobs() {
		return resumeJobs;
	}

	public void setResumeJobs(Set resumeJobs) {
		this.resumeJobs = resumeJobs;
	}

	public Set getJobCollections() {
		return jobCollections;
	}

	public void setJobCollections(Set jobCollections) {
		this.jobCollections = jobCollections;
	}

	
}