package api.pg.pojo.landingpage;

import com.fasterxml.jackson.annotation.JsonInclude;

public class LandingPageTemplate {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String createdAt;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String updatedAt;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private Integer id;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private Integer version;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Data data;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean isEnabled;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private Integer cluster;
	
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Integer getCluster() {
		return cluster;
	}
	public void setCluster(Integer cluster) {
		this.cluster = cluster;
	}
	
}
