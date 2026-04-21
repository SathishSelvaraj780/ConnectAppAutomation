package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class SeleniumTest {

    protected WebDriver driver;
    private Logger logger = Logger.getLogger(SeleniumTest.class.getName());
    protected Properties config;

    // Load credentials from environment variables for security
    private final String USERNAME = System.getenv("BROWSERSTACK_USERNAME") != null 
            ? System.getenv("BROWSERSTACK_USERNAME") 
            : "sathishselvaraj_0eCocD";
    
    private final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY") != null 
            ? System.getenv("BROWSERSTACK_ACCESS_KEY") 
            : "ArhXgDKkWynrzWXRpvJ8";
    
    private final String BROWSERSTACK_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws Exception {
        logger.info("Running test in BrowserStack on " + browser);

        // Load config.properties for dynamic tags
        config = new Properties();
        config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

        // Use modern Selenium 4 capabilities API
        Object capabilities;
        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("browserName", "firefox");
                firefoxOptions.setCapability("browserVersion", "latest");
                firefoxOptions.setCapability("os", "Windows");
                firefoxOptions.setCapability("osVersion", "11");
                firefoxOptions.setCapability("name", "ConnectApp POM Test");
                firefoxOptions.setCapability("build", config.getProperty("buildName", "ConnectApp_Build_001"));
                firefoxOptions.setCapability("customTag1", config.getProperty("customTag1", "POM"));
                firefoxOptions.setCapability("customTag2", config.getProperty("customTag2", "Regression"));
                firefoxOptions.setCapability("customTag3", config.getProperty("customTag3", "SmokeTest"));
                capabilities = firefoxOptions;
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("browserName", "edge");
                edgeOptions.setCapability("browserVersion", "latest");
                edgeOptions.setCapability("os", "Windows");
                edgeOptions.setCapability("osVersion", "11");
                edgeOptions.setCapability("name", "ConnectApp POM Test");
                edgeOptions.setCapability("build", config.getProperty("buildName", "ConnectApp_Build_001"));
                edgeOptions.setCapability("customTag1", config.getProperty("customTag1", "POM"));
                edgeOptions.setCapability("customTag2", config.getProperty("customTag2", "Regression"));
                edgeOptions.setCapability("customTag3", config.getProperty("customTag3", "SmokeTest"));
                capabilities = edgeOptions;
                break;
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("browserName", "chrome");
                chromeOptions.setCapability("browserVersion", "latest");
                chromeOptions.setCapability("os", "Windows");
                chromeOptions.setCapability("osVersion", "11");
                chromeOptions.setCapability("name", "ConnectApp POM Test");
                chromeOptions.setCapability("build", config.getProperty("buildName", "ConnectApp_Build_001"));
                chromeOptions.setCapability("customTag1", config.getProperty("customTag1", "POM"));
                chromeOptions.setCapability("customTag2", config.getProperty("customTag2", "Regression"));
                chromeOptions.setCapability("customTag3", config.getProperty("customTag3", "SmokeTest"));
                capabilities = chromeOptions;
                break;
        }

        driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), (org.openqa.selenium.Capabilities) capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); // maximize cloud browser
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}