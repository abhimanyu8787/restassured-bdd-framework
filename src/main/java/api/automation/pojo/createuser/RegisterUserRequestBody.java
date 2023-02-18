package api.automation.pojo.createuser;

public class RegisterUserRequestBody {
    
    private String email;
    private String password;
        
    public RegisterUserRequestBody(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
