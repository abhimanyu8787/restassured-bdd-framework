package api.pg.pojo.landingpage;

public class Section {
	
	private String sectionId;
	private String header;
	private String description;
	private String btnLabel;
	private String btnLink;
	private String image;
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBtnLabel() {
		return btnLabel;
	}
	public void setBtnLabel(String btnLabel) {
		this.btnLabel = btnLabel;
	}
	public String getBtnLink() {
		return btnLink;
	}
	public void setBtnLink(String btnLink) {
		this.btnLink = btnLink;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
