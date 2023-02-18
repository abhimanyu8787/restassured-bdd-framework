package api.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty" }, monochrome = true, glue = {
        "api.automation.stepdefinitions" }, tags = "@Smoke")
public class TestRunner {

}
