package api.pg.pojo.landingpage;

public class User {
	
	private Integer id;
	private String displayName;
	private String photoUrl;
	private boolean showProfilePic;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayedName) {
		this.displayName = displayedName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public boolean isShowProfilePic() {
		return showProfilePic;
	}
	public void setShowProfilePic(boolean showProfilePic) {
		this.showProfilePic = showProfilePic;
	}
	
}
