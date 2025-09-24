package util;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import factory.DriverManage;

public class Hooks {

    private final Util util;

    public Hooks(Util util) {
        this.util = util;
    }

	/*
	 * @Before public void setUp(Scenario scenario) throws Exception {
	 * DriverManage.startDriver(); }
	 */

    @After
    public void tearDown() {
        DriverManage.quitDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                WebDriver driver = DriverManage.getDriver();

                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "test-output/screenshots/"
                        + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".png";

                byte[] screenshot = FileUtils.readFileToByteArray(src);

                scenario.attach(screenshot, "image/png", "Failure Screenshot");

                ExtentManager.getTest().fail("Step failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            } catch (Exception e) {
                System.out.println("Screenshot capture failed: " + e.getMessage());
            }
        }
    }
}
