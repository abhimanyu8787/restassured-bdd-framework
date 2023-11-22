package api.pg.pojo.landingpage;

import java.util.List;

public class Benefits {
	
	private String header;
	private boolean enabled;
	private List<BenefitsData> data;
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<BenefitsData> getData() {
		return data;
	}
	public void setData(List<BenefitsData> data) {
		this.data = data;
	}

}
