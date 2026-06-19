package modules.login.tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import modules.login.pages.LoginPage;
import utils.TestDataProvider;

import java.time.Duration;
@Epic("Login")
@Feature("Login Functionality")
public class ConnectLoginTest extends SeleniumTest {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user can able to login with valid credentials and cannot login with invalid credentials")
    @Test(groups = {"smoke", "regression", "sanity"}, dataProvider = "loginData",
            dataProviderClass = TestDataProvider.class, description = "Data Driven Login Validation")
    public void appPositiveLogin(String username,
                                 String password,
                                 String expectedResult) {
        getDriver().get(config.getProperty("app.url"));

        // Initialize the page object
        LoginPage login = new LoginPage(getDriver());

        // Perform login actions
        login.enterUsername(username);
        ;
        login.enterPassword(password);
        login.clickLogin();

        // Wait for dashboard
        if (expectedResult.equalsIgnoreCase("Pass")) {

            WebDriverWait wait =
                    new WebDriverWait(
                            getDriver(),
                            Duration.ofSeconds(20));

            Assert.assertTrue(
                    wait.until(
                                    ExpectedConditions.visibilityOfElementLocated(
                                            By.id("top-menu")))
                            .isDisplayed(),
                    "Dashboard not displayed");

            System.out.println(
                    "Login Passed for user : "
                            + username);

        } else {

            String actualError =
                    login.getErrorMessage();

            Assert.assertEquals(
                    actualError,
                    "Invalid username or password");

            System.out.println(
                    "Negative Login Validated for user : "
                            + username);
        }
    }
}



