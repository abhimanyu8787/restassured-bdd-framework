package api.automation.utils;

import java.io.File;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GenericMethods {

    public void validateWithSchema(Response response, String jsonSchema) throws Exception {
        APIResources resourceAPI = APIResources.valueOf(jsonSchema);
        System.out.println("Validating with JsonSchema: " + resourceAPI.getResource());
        String schemaFilePath = resourceAPI.getResource();
        File responseSchema = new File(schemaFilePath);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(responseSchema));
    }

}
