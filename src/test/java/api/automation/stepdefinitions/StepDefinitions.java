package api.automation.stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import static org.junit.Assert.*;

import api.automation.utils.APIResources;
import api.automation.utils.GenericMethods;
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
    
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuilder testDataBuilder = new TestDataBuilder();
    JsonPath responseJsonObject;
    GenericMethods genericMethods;
    
    public StepDefinitions() {
        genericMethods = new GenericMethods();
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
            response = res.when().get(pathURL);
        }
    }

    @Then("verify if API returns with status code {int}")
    public void verify_if_api_returns_with_status_code(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("verify API response against {string} schema")
    public void verify_api_response_against_schema(String schemaFileName) throws Exception {
        genericMethods.validateWithSchema(response, schemaFileName);
    }

}
