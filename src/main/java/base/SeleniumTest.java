package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;


public class SeleniumTest {

    public static WebDriver driver;

    private Logger logger =
            Logger.getLogger(SeleniumTest.class.getName());

    protected Properties config;

    // BrowserStack Credentials
    private final String USERNAME =
            System.getenv("BROWSERSTACK_USERNAME") != null
                    ? System.getenv("BROWSERSTACK_USERNAME")
                    : "sathishselvaraj_0eCocD";

    private final String ACCESS_KEY =
            System.getenv("BROWSERSTACK_ACCESS_KEY") != null
                    ? System.getenv("BROWSERSTACK_ACCESS_KEY")
                    : "ArhXgDKkWynrzWXRpvJ8";

    private final String BROWSERSTACK_URL =
            "https://" + USERNAME + ":" + ACCESS_KEY +
                    "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "runmode"})

    public void setUp(

            @Optional("chrome") String browser,
            @Optional("browserstack") String runmode)

            throws Exception {

        logger.info("RunMode : " + runmode);
        logger.info("Browser : " + browser);

        // Load config file
        config = new Properties();

        config.load(
                getClass()
                        .getClassLoader()
                        .getResourceAsStream("config.properties"));

        // =========================
        // LOCAL EXECUTION
        // =========================

        if (runmode.equalsIgnoreCase("local")) {

            switch (browser.toLowerCase()) {

                case "firefox":

                    WebDriverManager.firefoxdriver().setup();

                    driver = new FirefoxDriver();

                    break;

                case "edge":

                    WebDriverManager.edgedriver().setup();

                    driver = new EdgeDriver();

                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();

                    options.addArguments("--force-device-scale-factor=0.80");
                    

                    driver = new ChromeDriver(options);


                    break;
            }
            driver.manage().window().maximize();
        }

        // =========================
        // BROWSERSTACK EXECUTION
        // =========================

        else {

            switch (browser.toLowerCase()) {

                // ================= CHROME =================

                case "chrome":

                    ChromeOptions chromeOptions =
                            new ChromeOptions();

                    chromeOptions.setBrowserVersion("latest");

                    HashMap<String, Object> chromeBstackOptions =
                            new HashMap<>();

                    chromeBstackOptions.put("os", "Windows");
                    chromeBstackOptions.put("osVersion", "11");

                    chromeBstackOptions.put(
                            "projectName",
                            "BrowserStack Connect");

                    chromeBstackOptions.put(
                            "buildName",
                            config.getProperty(
                                    "buildName",
                                    "ConnectApp_Build_001"));

                    chromeBstackOptions.put(
                            "sessionName",
                            "ConnectApp POM Test");

                    chromeOptions.setCapability(
                            "bstack:options",
                            chromeBstackOptions);

                    driver = new RemoteWebDriver(
                            new URL(BROWSERSTACK_URL),
                            chromeOptions);
                    driver.manage().window().setSize(
                            new Dimension(1920, 1080));

                    break;

                // ================= FIREFOX =================

                case "firefox":

                    FirefoxOptions firefoxOptions =
                            new FirefoxOptions();

                    firefoxOptions.setBrowserVersion("latest");

                    HashMap<String, Object> firefoxBstackOptions =
                            new HashMap<>();

                    firefoxBstackOptions.put("os", "Windows");
                    firefoxBstackOptions.put("osVersion", "11");

                    firefoxBstackOptions.put(
                            "projectName",
                            "BrowserStack Connect");

                    firefoxBstackOptions.put(
                            "buildName",
                            config.getProperty(
                                    "buildName",
                                    "ConnectApp_Build_001"));

                    firefoxBstackOptions.put(
                            "sessionName",
                            "ConnectApp POM Test");

                    firefoxOptions.setCapability(
                            "bstack:options",
                            firefoxBstackOptions);

                    driver = new RemoteWebDriver(
                            new URL(BROWSERSTACK_URL),
                            firefoxOptions);

                    break;

                // ================= EDGE =================

                case "edge":

                    EdgeOptions edgeOptions =
                            new EdgeOptions();

                    edgeOptions.setBrowserVersion("latest");

                    HashMap<String, Object> edgeBstackOptions =
                            new HashMap<>();

                    edgeBstackOptions.put("os", "Windows");
                    edgeBstackOptions.put("osVersion", "11");

                    edgeBstackOptions.put(
                            "projectName",
                            "BrowserStack Connect");

                    edgeBstackOptions.put(
                            "buildName",
                            config.getProperty(
                                    "buildName",
                                    "ConnectApp_Build_001"));

                    edgeBstackOptions.put(
                            "sessionName",
                            "ConnectApp POM Test");

                    edgeOptions.setCapability(
                            "bstack:options",
                            edgeBstackOptions);

                    driver = new RemoteWebDriver(
                            new URL(BROWSERSTACK_URL),
                            edgeOptions);

                    break;
            }
        }

        // =========================
        // COMMON SETUP
        // =========================

     driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(alwaysRun = true)

    public void tearDown() {
        System.out.println("Closing browser");

        if (driver != null) {

           driver.quit();
           System.out.println("Browser closed");
        }
    }

    public WebDriver getDriver() {

        return driver;
    }
}