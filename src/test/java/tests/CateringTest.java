package tests;

import base.SeleniumTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CateringTopUp;
import pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CateringTest extends SeleniumTest {

    @Test
    public void appCateringTopup() {
        driver.get(config.getProperty("app.url"));

        // Step 2: Login
        LoginPage Login = new LoginPage(driver);
        Login.enterUsername("shakeel.s22");
        Login.enterPassword("Welcome1234@");
        Login.clickLogin();
        // Optional: wait for login to complete or dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://qa-connect.phoenixhse.com/Home/Home"));
        //Open Catering Menu
        CateringTopUp cateringTopUp1 = new CateringTopUp(driver);
        cateringTopUp1.openCateringMenu();
        cateringTopUp1.openTopUp();
        cateringTopUp1.Scrolldown();
        cateringTopUp1.Enteramount(500);
        cateringTopUp1.clickProceed();
        cateringTopUp1.finalProceed();
        //ValidateCateringTest
        wait.until(ExpectedConditions.urlContains("ap-gateway.mastercard.com"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("ap-gateway.mastercard.com"));
    }
}
