package api.pg.pojo.landingpage;

import java.util.List;

public class Testimonials {
	
	private boolean enabled;
	private String header;
	private String sectionImg;
	private List<TestimonialsData> data;
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getSectionImg() {
		return sectionImg;
	}
	public void setSectionImg(String sectionImg) {
		this.sectionImg = sectionImg;
	}
	public List<TestimonialsData> getData() {
		return data;
	}
	public void setData(List<TestimonialsData> data) {
		this.data = data;
	}
	
}
