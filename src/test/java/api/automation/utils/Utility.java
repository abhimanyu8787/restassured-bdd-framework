package api.automation.utils;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {
    
    public static RequestSpecification req;
    public static ResponseSpecification responsespec;
    
    public static String getGlobalProperties(String key) throws IOException {
        FileReader reader = new FileReader("GlobalSettings.properties");
        Properties globalProperties = new Properties();
        globalProperties.load(reader);
        return globalProperties.getProperty(key);
    }
    
    public RequestSpecification listUsersRequestSpecifications() throws IOException {
        if(req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("reqResBaseUrl"))
                    .addHeader("accept", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }
    
    public ResponseSpecification listUsersResponseSpecification() {
        if(responsespec == null) {
            responsespec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
            return responsespec;
        }
        
        return responsespec;
    }

}
