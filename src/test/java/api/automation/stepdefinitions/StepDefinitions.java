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
        }
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

}
