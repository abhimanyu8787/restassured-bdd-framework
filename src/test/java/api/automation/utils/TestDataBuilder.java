package api.automation.utils;

import api.automation.pojo.createuser.RegisterUserRequestBody;
import api.automation.pojo.loginuser.LoginUserRequestBody;

public class TestDataBuilder {
    
    private RegisterUserRequestBody registerUserRequestBody;
    private LoginUserRequestBody loginUserRequestBody;
    
    public RegisterUserRequestBody registerUserRequestPayload(String email, String password) {
        registerUserRequestBody = new RegisterUserRequestBody(email, password);
        return registerUserRequestBody;
    }
    
    public LoginUserRequestBody loginUserRequestBody(String email, String password) {
        loginUserRequestBody = new LoginUserRequestBody(email, password);
        return loginUserRequestBody;
    }

}
