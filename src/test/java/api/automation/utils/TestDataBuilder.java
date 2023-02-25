package api.automation.utils;

import api.automation.pojo.createuser.CreateUserRequestBody;
import api.automation.pojo.loginuser.LoginUserRequestBody;
import api.automation.pojo.registeruser.RegisterUserRequestBody;

public class TestDataBuilder {
    
    private RegisterUserRequestBody registerUserRequestBody;
    private LoginUserRequestBody loginUserRequestBody;
    private CreateUserRequestBody createUserRequestBody;
    
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

}
