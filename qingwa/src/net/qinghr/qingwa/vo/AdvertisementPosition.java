package net.qinghr.qingwa.vo;

import java.sql.Timestamp;

/**
 * Advertisementposition entity. @author MyEclipse Persistence Tools
 */

public class AdvertisementPosition implements java.io.Serializable {

	// Fields

	private Integer id;
	private AdvertisementCompany advertisementCompany;
	private String position;
	private Timestamp editTime;
	private Timestamp inputTime;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public AdvertisementPosition() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public AdvertisementCompany getAdvertisementCompany() {
		return advertisementCompany;
	}

	public void setAdvertisementCompany(AdvertisementCompany advertisementCompany) {
		this.advertisementCompany = advertisementCompany;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}