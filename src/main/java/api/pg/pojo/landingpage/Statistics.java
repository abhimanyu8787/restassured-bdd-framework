package api.pg.pojo.landingpage;

import java.util.List;

public class Statistics {
	
	private boolean enabled;
	private List<StatisticsData> data;
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<StatisticsData> getData() {
		return data;
	}
	public void setData(List<StatisticsData> data) {
		this.data = data;
	}
	
}
