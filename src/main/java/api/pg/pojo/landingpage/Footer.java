package api.pg.pojo.landingpage;

public class Footer {
	
	private boolean enabled;
	private String footerImage;
	private String header;
	private String description;
	private String buttonLabel;
	private String buttonLink;
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getFooterImage() {
		return footerImage;
	}
	public void setFooterImage(String footerImage) {
		this.footerImage = footerImage;
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
	public String getButtonLabel() {
		return buttonLabel;
	}
	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}
	public String getButtonLink() {
		return buttonLink;
	}
	public void setButtonLink(String buttonLink) {
		this.buttonLink = buttonLink;
	}
}
