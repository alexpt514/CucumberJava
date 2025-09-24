package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManage2 {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void startDriver() throws IOException {
        if (driver.get() == null) {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
            Properties prop = new Properties();
            prop.load(file);

            String browserFromProp = prop.getProperty("browser").toLowerCase();
            String browserFromMaven = System.getProperty("browser");

            String browser = (browserFromMaven != null) ? browserFromMaven.toLowerCase() : browserFromProp;
            String url = prop.getProperty("QAurl");

            WebDriver localDriver;

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless"); // optional
                    options.addArguments("--disable-gpu");
                    localDriver = new ChromeDriver(options);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    localDriver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    localDriver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            localDriver.manage().window().maximize();
            localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            localDriver.get(url);

            driver.set(localDriver);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Very important to clean up the ThreadLocal
        }
    }
}
