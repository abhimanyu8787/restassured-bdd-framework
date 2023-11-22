package api.automation.utils;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
    private TestDataBuilder testDataBuilder;
    
    public static String getGlobalProperties(String key) throws IOException {
        FileReader reader = new FileReader("GlobalSettings.properties");
        Properties globalProperties = new Properties();
        globalProperties.load(reader);
        return globalProperties.getProperty(key);
    }
    
    public RequestSpecification listUsersRequestSpecifications() throws IOException {
        if(req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("api-logs//listUsersLogs.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("reqResBaseUrl"))
                    .addHeader("accept", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }
    
    public RequestSpecification registerUserRequestSpecification(String email, String password) throws IOException {
        PrintStream log = new PrintStream(new FileOutputStream("api-logs//registerUserLogs.txt"));
        testDataBuilder = new TestDataBuilder();
        req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("reqResBaseUrl"))
                .addHeader("accept", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).setBody(testDataBuilder.registerUserRequestPayload(email, password)).build();
        return req;
    }
    
    public RequestSpecification loginUserRequestSpecification(String email, String password) throws IOException {
        PrintStream log = new PrintStream(new FileOutputStream("api-logs//loginUserLogs.txt"));
        testDataBuilder = new TestDataBuilder();
        req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("reqResBaseUrl"))
                .addHeader("accept", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).setBody(testDataBuilder.loginUserRequestBody(email, password)).build();
        return req;
    }
    
    public RequestSpecification createUserRequestSpecification(String name, String job) throws IOException {
        PrintStream log = new PrintStream(new FileOutputStream("api-logs//createUserLogs.txt"));
        testDataBuilder = new TestDataBuilder();
        req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("reqResBaseUrl"))
                .addHeader("accept", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).setBody(testDataBuilder.createUserRequestPayload(name, job)).build();
        return req;
    }
    
    public ResponseSpecification listUsersResponseSpecification() {
        if(responsespec == null) {
            responsespec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
            return responsespec;
        }
        
        return responsespec;
    }
    
    public RequestSpecification pgSignupAPIRequestSpec() throws IOException {
    	PrintStream log = new PrintStream(new FileOutputStream("api-logs//pgSignup.txt"));
    	req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("pgBaseUrl"))
    			.addHeader("authority", "test-standardautomation-hub.pg-test.com")
    			.addHeader("accept", "application/json, text/plain, */*")
    			.addHeader("accept-language", "en-US,en;q=0.9")
    			.addHeader("content-type", "application/json")
    			.addHeader("hubidentifier", "newhub926737103395")
    			.addHeader("origin", "https://test-standardautomation-hub.pg-test.com")
    			.addHeader("referer", "https://test-standardautomation-hub.pg-test.com/hub/newhub926737103395/auth/create-account")
    			.addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
    	return req;
    }
    
    public RequestSpecification pgUsersAPIRequestSpec(String token) throws IOException {
    	PrintStream log = new PrintStream(new FileOutputStream("api-logs//pgSelectUserType.txt"));
    	req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("pgBaseUrl"))
    			.addHeader("authority", "test-standardautomation-hub.pg-test.com")
    			.addHeader("authorization","bearer "+ token)
    			.addHeader("accept", "application/json, text/plain, */*")
    			.addHeader("accept-language", "en-US,en;q=0.9")
    			.addHeader("content-type", "application/json")
    			.addHeader("hubidentifier", "newhub926737103395")
    			.addHeader("origin", "https://test-standardautomation-hub.pg-test.com")
    			.addHeader("referer", "https://test-standardautomation-hub.pg-test.com/hub/newhub926737103395/signup")
    			.addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
    	return req;
    }
    
    public RequestSpecification pgLandingPageTemplate(String version) throws IOException {
    	PrintStream log = new PrintStream(new FileOutputStream("api-logs//pgLandingPageTemplate.txt"));
    	req = new RequestSpecBuilder().setBaseUri(getGlobalProperties("pgBaseUrl"))
    			.addHeader("accept", "application/json, text/plain, */*")
    			.addHeader("accept-language", "en-US,en;q=0.9")
    			.addHeader("Accept-Encoding", "gzip, deflate, br")
    			.addParam("version", version)
    			.addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
    	return req;
    }
    
    public String getUniqueEmailId() {
		DateTimeFormatter day = DateTimeFormatter.ofPattern("ddMMMHHmmss", Locale.US);
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HHmmss");
		ZonedDateTime now = ZonedDateTime.now();
		String emailAppender = day.format(now);

		int MrgOrEvg = Integer.parseInt(time.format(now).substring(0, 2));
		String which_Ing = "mrg";
		if (MrgOrEvg > 12)
			which_Ing = "evg";

		String dynamicEmail = "test+" + emailAppender + which_Ing + "@epxlvj6o.mailosaur.net";
		return dynamicEmail;
	}
    
    public static String getUniqueNumericString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMss");
        return now.format(formatter);
    }
    
    

}
