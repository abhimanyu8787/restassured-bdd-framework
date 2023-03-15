package api.automation.stepdefinitions;

import static org.junit.Assert.*;
import java.util.List;

import api.automation.utils.GenericMethods;
import api.automation.utils.TestContextSetup;
import api.automation.utils.Utility;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ListUsersStepDefinitions extends Utility{
    
    TestContextSetup testContextSetup;
    Response response;
    JsonPath responseJsonObject;
    GenericMethods genericMethods;
    List<String> emailList;
    
    public ListUsersStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.genericMethods = new GenericMethods();
    }
    
    @Then("verify if all the emails in the response are unique")
    public void verify_if_all_the_emails_in_the_response_are_unique() {
        testContextSetup.responseJsonObject = testContextSetup.response.jsonPath();
        emailList = testContextSetup.responseJsonObject.getList("data.email");
        List<String> duplicateList = genericMethods.findDuplicates(emailList);
        if(duplicateList.size()!=0)
            fail(duplicateList.size()+" Duplicate Emails Found: "+duplicateList);
        else
            assertEquals(0,duplicateList.size());
    }

}
