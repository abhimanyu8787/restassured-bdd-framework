package api.pg.pojo.signup;

public class SignupBody {
	
	private String email;
	private String password;
	private boolean agreementAccepted;
	private Integer method;
	private String firstName;
	private String lastName;
	private String source;
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
	public boolean isAgreementAccepted() {
		return agreementAccepted;
	}
	public void setAgreementAccepted(boolean agreementAccepted) {
		this.agreementAccepted = agreementAccepted;
	}
	public Integer getMethod() {
		return method;
	}
	public void setMethod(Integer method) {
		this.method = method;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public SignupBody(String email, String password, boolean agreementAccepted, Integer method, String firstName,
			String lastName, String source) {
		super();
		this.email = email;
		this.password = password;
		this.agreementAccepted = agreementAccepted;
		this.method = method;
		this.firstName = firstName;
		this.lastName = lastName;
		this.source = source;
	}
}
