package api.automation.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    public List<String> findDuplicates(List<String> stringList){
        List<String> duplicatesList = new ArrayList<String>();
        Set<String> uniqueList = new HashSet<String>();
        for(String str : stringList) {
            if(!uniqueList.contains(str))
                uniqueList.add(str);
            else
                duplicatesList.add(str);
        }
        return duplicatesList;
    }

}
