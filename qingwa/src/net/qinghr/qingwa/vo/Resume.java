package net.qinghr.qingwa.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Resume entity. @author MyEclipse Persistence Tools
 */

public class Resume implements java.io.Serializable {

	// Fields

	private Integer id;
	private Area area;
	private CompanyJobNature companyJobNature;
	private PersonalExperience personalExperience;
	private Degree degree;
	private User user;
	private String title;
	private String userName;
	private String pic;
	private String sex;
	private String tel;
	private String email;
	private String direction;
	private Current current;
	private Integer view;
	private Timestamp eaitTime;
	private String expectedJob;
	private Integer minSalary;
	private Integer maxSalary;
	private Integer downCount;
	private Timestamp releaseTime;
	private Boolean isRelease;
	private Boolean isDefault;
	private Boolean enable;
	private Set resumeJobs = new HashSet(0);
	private Set educationalBackgrounds = new HashSet(0);
	private Set results = new HashSet(0);
	private Set projects = new HashSet(0);

	// Constructors

	/** default constructor */
	public Resume() {
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

	public CompanyJobNature getCompanyJobNature() {
		return companyJobNature;
	}

	public void setCompanyJobNature(CompanyJobNature companyJobNature) {
		this.companyJobNature = companyJobNature;
	}

	public PersonalExperience getPersonalExperience() {
		return personalExperience;
	}

	public void setPersonalExperience(PersonalExperience personalExperience) {
		this.personalExperience = personalExperience;
	}
	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Timestamp getEaitTime() {
		return eaitTime;
	}

	public void setEaitTime(Timestamp eaitTime) {
		this.eaitTime = eaitTime;
	}

	public String getExpectedJob() {
		return expectedJob;
	}

	public void setExpectedJob(String expectedJob) {
		this.expectedJob = expectedJob;
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

	public Integer getDownCount() {
		return downCount;
	}

	public void setDownCount(Integer downCount) {
		this.downCount = downCount;
	}

	public Timestamp getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Boolean getIsRelease() {
		return isRelease;
	}

	public void setIsRelease(Boolean isRelease) {
		this.isRelease = isRelease;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
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

	public Set getEducationalBackgrounds() {
		return educationalBackgrounds;
	}

	public void setEducationalBackgrounds(Set educationalBackgrounds) {
		this.educationalBackgrounds = educationalBackgrounds;
	}

	public Set getResults() {
		return results;
	}

	public void setResults(Set results) {
		this.results = results;
	}

	public Set getProjects() {
		return projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	
}