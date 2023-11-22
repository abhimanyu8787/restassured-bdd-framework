package api.pg.pojo.landingpage;

import java.util.List;

public class Student {
	
	private boolean enabled;
	private List<FaqData> data;
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<FaqData> getData() {
		return data;
	}
	public void setData(List<FaqData> data) {
		this.data = data;
	}
	
}
