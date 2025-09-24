package StepDef;

import org.junit.runner.RunWith;
//import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//import org.junit.platform.suite.api.*;
//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.Suite;

//import static io.cucumber.junit.platform.engine.Constants.*;


/*@Cucumber
@Suite
@SelectClasspathResource("Features") // relative to src/test/resources
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "StepDef,util")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/newHtmlReports.html, json:target/JsonReports.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@automation1")

//@SuppressWarnings("deprecation")
@Cucumber
*
*/

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/Features",

  glue={"StepDef", "util"}, monochrome =true , plugin = {"pretty",
  "html:target/newHtmlReports.html","json:target/JsonReports.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"},//plugin tocreate html reports ,"io.github.selcukes.extent.reporter.cucumber.CukesReporter"
  
  tags="@adding2")
 


public class TestRunner {

	

}
