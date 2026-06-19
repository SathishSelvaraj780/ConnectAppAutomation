package modules.login.tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataProvider;

import java.time.Duration;
@Epic("Logout")
@Feature("Logout Functionality")
public class AppLogoutTest extends SeleniumTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate user can able to logout from the application and redirected to login page")
    @Test(groups = {"smoke", "regression", "sanity"})
    public void appLogoutTest(){
        getDriver().get(config.getProperty("app.url"));


        // Initialize the page object
        LoginPage login = new LoginPage(getDriver());
        // Perform login actions with invalid credentials
        login.enterUsername("faizal.a9");
        login.enterPassword("Welcome1234@");
        login.clickLogin();

        login.clickOnOpenProfile();
        login.clicklogout();

        //Validate Logout
        WebDriverWait wait =
                new WebDriverWait(getDriver(),
                        Duration.ofSeconds(20));
        Assert.assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitLogin"))).isDisplayed(),
                "Login button not visible after logout"
        );

    }
}
