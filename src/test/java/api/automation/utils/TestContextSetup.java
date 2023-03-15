package api.automation.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestContextSetup {
    
    public Response response;
    public JsonPath responseJsonObject;
    public GenericMethods genericMethods;
    
    public TestContextSetup() throws Exception{
        genericMethods = new GenericMethods();
    }

}
