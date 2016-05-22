package net.qinghr.qingwa.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * CompanyInfo entity. @author MyEclipse Persistence Tools
 */

public class CompanyInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private CompanyStage companyStage;
     private Area area;
     private CompanyScale companyScale;
     private Industry industry;
     private User user;
     private String fullName;
     private String shortName;
     private String pic;
     private String url;
     private String address;
     private Float longitude;
     private Float latitude;
     private String direction;
     private String detail;
     private Boolean isValidate;
     private String validatePic;
     private String validateAdmin;
     private Timestamp validateTime;
     private Boolean isPass;
     private String phone;
     private String email;
     private Integer downloadCount;
     private Integer createJobCount;
     private Integer view;
     private Boolean isTop;
     private Timestamp editTime;
     private Boolean canCreateJob;
     private Boolean enable;
     private Set companyLabels = new HashSet(0);
     private Set companyTemptations = new HashSet(0);
     private Set companyInvestors = new HashSet(0);
     private Set companyPics = new HashSet(0);
     private Set companyProducts = new HashSet(0);
     private Set companyJobs = new HashSet(0);


    // Constructors

    /** default constructor */
    public CompanyInfo() {
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


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public CompanyScale getCompanyScale() {
		return companyScale;
	}


	public void setCompanyScale(CompanyScale companyScale) {
		this.companyScale = companyScale;
	}


	public Industry getIndustry() {
		return industry;
	}


	public void setIndustry(Industry industry) {
		this.industry = industry;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public Boolean getIsValidate() {
		return isValidate;
	}


	public void setIsValidate(Boolean isValidate) {
		this.isValidate = isValidate;
	}


	public String getValidatePic() {
		return validatePic;
	}


	public void setValidatePic(String validatePic) {
		this.validatePic = validatePic;
	}


	public String getValidateAdmin() {
		return validateAdmin;
	}


	public void setValidateAdmin(String validateAdmin) {
		this.validateAdmin = validateAdmin;
	}


	public Timestamp getValidateTime() {
		return validateTime;
	}


	public void setValidateTime(Timestamp validateTime) {
		this.validateTime = validateTime;
	}

	public Boolean getIsPass() {
		return isPass;
	}


	public void setIsPass(Boolean isPass) {
		this.isPass = isPass;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getDownloadCount() {
		return downloadCount;
	}


	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}


	public Integer getCreateJobCount() {
		return createJobCount;
	}


	public void setCreateJobCount(Integer createJobCount) {
		this.createJobCount = createJobCount;
	}


	public Integer getView() {
		return view;
	}


	public void setView(Integer view) {
		this.view = view;
	}


	public Boolean getIsTop() {
		return isTop;
	}


	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}


	public Timestamp getEditTime() {
		return editTime;
	}


	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}


	public Boolean getCanCreateJob() {
		return canCreateJob;
	}


	public void setCanCreateJob(Boolean canCreateJob) {
		this.canCreateJob = canCreateJob;
	}


	public Boolean getEnable() {
		return enable;
	}


	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


	public Set getCompanyLabels() {
		return companyLabels;
	}


	public void setCompanyLabels(Set companyLabels) {
		this.companyLabels = companyLabels;
	}


	public Set getCompanyTemptations() {
		return companyTemptations;
	}


	public void setCompanyTemptations(Set companyTemptations) {
		this.companyTemptations = companyTemptations;
	}


	public Set getCompanyInvestors() {
		return companyInvestors;
	}


	public void setCompanyInvestors(Set companyInvestors) {
		this.companyInvestors = companyInvestors;
	}


	public Set getCompanyPics() {
		return companyPics;
	}


	public void setCompanyPics(Set companyPics) {
		this.companyPics = companyPics;
	}


	public Set getCompanyProducts() {
		return companyProducts;
	}


	public void setCompanyProducts(Set companyProducts) {
		this.companyProducts = companyProducts;
	}


	public Set getCompanyJobs() {
		return companyJobs;
	}


	public void setCompanyJobs(Set companyJobs) {
		this.companyJobs = companyJobs;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
   
}