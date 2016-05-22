package net.qinghr.qingwa.vo;

/**
 * Config entity. @author MyEclipse Persistence Tools
 */

public class Config implements java.io.Serializable {

	// Fields

	private Integer id;
	private String configKey;
	private String configValue;
	private String configDescription;
	private Boolean enable;

	// Constructors

	/** default constructor */
	public Config() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigDescription() {
		return configDescription;
	}

	public void setConfigDescription(String configDescription) {
		this.configDescription = configDescription;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	
}