package api.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", 
        plugin = { "pretty",
                "json:target/jsonReports/cucumber-report.json",
                "html:target/htmlReports/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true, 
        glue = {"api.automation.stepdefinitions" }, tags = "@pglandingpage")
public class TestRunner {

}
