package modules.catering.topuptest;

import base.SeleniumTest;
import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import modules.catering.pages.CateringTopUp;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
@Epic("Catering")
@Feature("Top Up the Wallet")
public class CateringTest extends SeleniumTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate user can able to top up the wallet through catering top up menu and redirect to payment gateway")
    @Test(groups = {"regression"})
    public void appCateringTopup() {
        driver.get(config.getProperty("app.url"));

        // Step 2: Login with credentials from config
        LoginPage Login = new LoginPage(driver);
        Login.enterUsername(config.getProperty("test.username", "oleg.v4"));
        Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        Login.clickLogin();
        // Optional: wait for login to complete or dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://qa-connectv2.phoenixhse.com/Home/Home"));
        //Open Catering Menu
        CateringTopUp cateringTopUp1 = new CateringTopUp(driver);
        cateringTopUp1.openCateringMenu();
        cateringTopUp1.openTopUp();
        cateringTopUp1.scrollDown();
        cateringTopUp1.enterAmount(500);
        cateringTopUp1.clickProceed();
        cateringTopUp1.finalProceed();
        //ValidateCateringTest
        wait.until(ExpectedConditions.urlContains("ap-gateway.mastercard.com"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("ap-gateway.mastercard.com"));
    }
}
