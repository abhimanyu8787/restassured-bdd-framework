package api.automation.stepdefinitions;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import static org.junit.Assert.*;
import api.automation.utils.APIResources;
import api.automation.utils.GenericMethods;
import api.automation.utils.TestContextSetup;
import api.automation.utils.TestDataBuilder;
import api.automation.utils.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinitions extends Utility{
    
    public TestContextSetup testContextSetup;
    public RequestSpecification res;
    public ResponseSpecification resspec;
    public Response response;
    public TestDataBuilder testDataBuilder = new TestDataBuilder();
    public JsonPath responseJsonObject;
    public GenericMethods genericMethods;
    
    public StepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.genericMethods = testContextSetup.genericMethods;
    }
    
    @Given("List Users API with {string} and {string}")
    public void list_users_api_with_and(String page, String perPage) throws IOException {
        res = given().spec(listUsersRequestSpecifications())
                .param("page", page)
                .param("per_page", perPage);
    }

    @When("user calls {string} API with GET http request")
    public void user_calls_api_with_get_http_request(String resource) {
        
        if(resource.equals("ListUsersAPI")) {
            APIResources resourceAPI = APIResources.valueOf(resource);
            String pathURL = resourceAPI.getResource();
            System.out.println("Resource URL: "+pathURL);
            testContextSetup.response = res.when().get(pathURL);
        }
    }

    @Then("verify if API returns with status code {int}")
    public void verify_if_api_returns_with_status_code(int statusCode) {
        assertEquals(statusCode, testContextSetup.response.getStatusCode());
    }

    @Then("verify API response against {string} schema")
    public void verify_api_response_against_schema(String schemaFileName) throws Exception {
        genericMethods.validateWithSchema(testContextSetup.response, schemaFileName);
    }
    
    @Given("Register User API with {string} and {string}")
    public void register_user_api_with_and(String email, String password) throws IOException {
        res = given().spec(registerUserRequestSpecification(email,password));
    }

    @When("user calls {string} with Post Http Request")
    public void user_calls_with_post_http_request(String resource) {
        if(resource.equals("RegisterUserAPI")) {
            APIResources resourceAPI = APIResources.valueOf(resource);
            String pathURL = resourceAPI.getResource();
            testContextSetup.response = res.when().post(pathURL);
        }else if(resource.equals("LoginAPI")) {
            APIResources resourceAPI = APIResources.valueOf(resource);
            String pathURL = resourceAPI.getResource();
            testContextSetup.response = res.when().post(pathURL);
        }else if(resource.equals("CreateUserAPI")) {
            APIResources resourceAPI = APIResources.valueOf(resource);
            String pathURL = resourceAPI.getResource();
            testContextSetup.response = res.when().post(pathURL);
        }else if(resource.equals("PgSignupAPI")) {
        	APIResources resourceAPI = APIResources.valueOf(resource);
            String pathURL = resourceAPI.getResource();
            testContextSetup.response = res.when().post(pathURL);
        }
        System.out.println(testContextSetup.response.asPrettyString());
    }
    
    @Given("Login API with {string} and {string}")
    public void login_api_with_and(String email, String password) throws IOException {
        res = given().spec(loginUserRequestSpecification(email, password));
    }

    @Then("verify if login is successful and token {string} is returned")
    public void verify_if_login_is_successful_and_token_is_returned(String string) {
        
    }
    
    @Given("Create User API with {string} and {string}")
    public void create_user_api_with_and(String name, String job) throws IOException {
        res = given().spec(createUserRequestSpecification(name,job));
    }
    
    @Given("I signup via api as {string} usertype")
    public void i_signup_via_api_as_usertype(String string) throws IOException {
    	testContextSetup.response = given().spec(pgSignupAPIRequestSpec())
        		.body(testDataBuilder.signupRequestPayload("abhimanyuRestAssured5@peoplegrove.com", "Testing@123", true, 1, "Abhimanyu Rest Assured", "Kumar", "create account page"))
        		.when().post("/api/auth/signup");
    	int responseCode = testContextSetup.response.getStatusCode();
    	System.out.println(testContextSetup.response.asString());
    	String token = testContextSetup.response.getBody().jsonPath().get("token");
    	
    	Response response2 = given().spec(pgSignupAPIRequestSpec())
    			.header("authorization", "bearer "+token)
    			.body(testDataBuilder.selectUsertypePayload(1247, "true", "SELECT_TYPE", "false", "alumni"))
    			.when().put("/api/users");
    	
    	int status = response2.getStatusCode();
    	System.out.println(response2.asString());
    }

    @When("I complete the signup process for {string} usertype")
    public void i_complete_the_signup_process_for_usertype(String string) {
        
    }
    
    @Given("Signup via Email with {string} usertype")
    public void signup_via_email_with_usertype(String string) throws IOException {
    	String email = getUniqueEmailId();
		String fname = "SignupF " + getUniqueNumericString();
		String lname = "SignupL " + getUniqueNumericString();
		String pwd = "Testing@123";
    	res = given().spec(pgSignupAPIRequestSpec())
        		.body(testDataBuilder.signupRequestPayload(email, pwd, true, 1, fname, lname, "create account page"));
    }

    @When("user calls {string} with Put Http Request")
    public void user_calls_with_put_http_request(String resource) throws Exception {
    	switch (resource.toUpperCase()) {
		case "PGSIGNUPAPI":
			APIResources resourceAPI = APIResources.valueOf(resource);
            String pathURL = resourceAPI.getResource();
            testContextSetup.response = res.when().put(pathURL);
			break;

		default:
			throw new Exception("Unsupported request name provided");
		}
    }
    
    @When("extract token from pg signup response")
    public void extract_token_from_pg_signup_response() {
    	testContextSetup.token = testContextSetup.response.getBody().jsonPath().get("token");
    }

}
