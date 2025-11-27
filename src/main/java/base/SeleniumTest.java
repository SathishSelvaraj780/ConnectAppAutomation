package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

    private final String USERNAME = "sathishselvaraj_0eCocD";
    private final String ACCESS_KEY = "ArhXgDKkWynrzWXRpvJ8";
    private final String BROWSERSTACK_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws Exception {
        logger.info("Running test in BrowserStack on " + browser);

        // Load config.properties for dynamic tags
        config = new Properties();
        config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser); // chrome, firefox, edge
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("osVersion", "11");

        //Session name & build name
        caps.setCapability("name", "ConnectApp POM Test");
        caps.setCapability("build", config.getProperty("buildName", "ConnectApp_Build_001"));

        //Custom Tags (up to 5)
        caps.setCapability("customTag1", config.getProperty("customTag1", "POM"));
        caps.setCapability("customTag2", config.getProperty("customTag2", "Regression"));
        caps.setCapability("customTag3", config.getProperty("customTag3", "SmokeTest"));
        // Add customTag4, customTag5 if needed

        driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), caps);
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