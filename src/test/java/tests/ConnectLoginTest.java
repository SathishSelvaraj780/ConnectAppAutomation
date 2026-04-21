package tests;

import base.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class ConnectLoginTest extends SeleniumTest {

    @Test
    public void appPositiveLogin() {
        driver.get(config.getProperty("app.url"));

        // Initialize the page object
        LoginPage login = new LoginPage(driver);

        // Perform login actions
        login.enterUsername(config.getProperty("test.username", "shakeel.s22"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        // Wait for dashboard
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("top-menu"))).isDisplayed(),
                "Dashboard not visible after login"
        );
    }

    @Test
    public void appNegativeLoginTest(){
        driver.get(config.getProperty("app.url"));

        // Initialize the page object
        LoginPage login = new LoginPage(driver);

        // Perform login actions with invalid credentials
        login.enterUsername("shakeel");
        login.enterPassword("Welcome");
        login.clickLogin();

        //Validate Error Message
        String actualError = login.getErrorMessage();
        String expectedError = "Invalid username or password";
        Assert.assertEquals(actualError, expectedError);
    }
}
