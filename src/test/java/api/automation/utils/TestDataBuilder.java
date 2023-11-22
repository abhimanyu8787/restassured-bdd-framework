package api.automation.utils;

import api.automation.pojo.createuser.CreateUserRequestBody;
import api.automation.pojo.loginuser.LoginUserRequestBody;
import api.automation.pojo.registeruser.RegisterUserRequestBody;
import api.pg.pojo.signup.SelectUsertype;
import api.pg.pojo.signup.SignupBody;

public class TestDataBuilder {
    
    private RegisterUserRequestBody registerUserRequestBody;
    private LoginUserRequestBody loginUserRequestBody;
    private CreateUserRequestBody createUserRequestBody;
    private SignupBody signupBody;
    private SelectUsertype selectUsertype;
    
    public RegisterUserRequestBody registerUserRequestPayload(String email, String password) {
        registerUserRequestBody = new RegisterUserRequestBody(email, password);
        return registerUserRequestBody;
    }
    
    public LoginUserRequestBody loginUserRequestBody(String email, String password) {
        loginUserRequestBody = new LoginUserRequestBody(email, password);
        return loginUserRequestBody;
    }
    
    public CreateUserRequestBody createUserRequestPayload(String email, String password) {
        createUserRequestBody = new CreateUserRequestBody(email, password);
        return createUserRequestBody;
    }
    
    public SignupBody signupRequestPayload(String email, String password, boolean agreementAccepted, Integer method, String firstName, String lastName, String source) {
    	signupBody = new SignupBody(email, password, agreementAccepted, method, firstName, lastName, source);
    	return signupBody;
    }
    
    public SelectUsertype selectUsertypePayload(int hubId, String getUserObject, String signupStage, String isBackPressed, String userType) {
    	selectUsertype = new SelectUsertype(hubId, getUserObject, signupStage, isBackPressed, userType);
    	return selectUsertype;
    }

}
