package api.pg.pojo.signup;


public class SelectUsertype {
	
    private int hubId;
    private String getUserObject;
    private String signupStage;
    private String isBackPressed;
    private String userType;

    public SelectUsertype(int hubId, String getUserObject, String signupStage, String isBackPressed, String userType) {
		super();
		this.hubId = hubId;
		this.getUserObject = getUserObject;
		this.signupStage = signupStage;
		this.isBackPressed = isBackPressed;
		this.userType = userType;
	}

	public int getHubId() {
        return hubId;
    }

    public void setHubId(int hubId) {
        this.hubId = hubId;
    }

    public String getGetUserObject() {
        return getUserObject;
    }

    public void setGetUserObject(String getUserObject) {
        this.getUserObject = getUserObject;
    }

    public String getSignupStage() {
        return signupStage;
    }

    public void setSignupStage(String signupStage) {
        this.signupStage = signupStage;
    }

    public String getIsBackPressed() {
        return isBackPressed;
    }

    public void setIsBackPressed(String isBackPressed) {
        this.isBackPressed = isBackPressed;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
