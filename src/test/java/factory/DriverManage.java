package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManage {

    // ThreadLocal driver for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void startDriver() throws IOException {
        if (Objects.isNull(driver.get())) {

            FileInputStream file = new FileInputStream(
                    System.getProperty("user.dir") + "//src//test//resources//global.properties");
            Properties prop = new Properties();
            prop.load(file);

            String url = prop.getProperty("QAurl");

            String browser_properties = prop.getProperty("browser").toLowerCase();
            String browser_maven = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : null;

            String browser = browser_maven != null ? browser_maven : browser_properties;

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments("--headless"); // enable if needed
                    //options.addArguments("--window-size=1920,1080"); // set to a large enough size
                    options.addArguments("--disable-gpu"); // Optional, for compatibility
                    driver.set(new ChromeDriver(options));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;

                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }


            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            getDriver().get(url);
            Dimension size = getDriver().manage().window().getSize();
            System.out.println("Window size: " + size);
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver.get())) {
            getDriver().quit();
            driver.remove(); // ✅ remove reference for thread safety
        }
    }
}
