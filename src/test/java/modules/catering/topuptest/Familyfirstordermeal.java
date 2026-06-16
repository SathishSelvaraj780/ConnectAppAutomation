package modules.catering.topuptest;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.catering.pages.Cateringmealbookingpage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("Catering")
@Feature("Alcarte Order")
public class Familyfirstordermeal extends SeleniumTest {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user can able to order meal through Alcarte menu and pay through wallet balance")
    @Test
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

        Cateringmealbookingpage cateringmealbookingpage = new Cateringmealbookingpage(driver);
        cateringmealbookingpage.openCateringMenu();
        cateringmealbookingpage.openViewMenu();
        cateringmealbookingpage.orderItem("Chicken Caesar Wrap");
        cateringmealbookingpage.checkoutItem();
        cateringmealbookingpage.selectpickupPoint("Main Cafe");
        String balance = cateringmealbookingpage.getWalletBalance();
        System.out.println("Wallet Balance: " + balance);
        cateringmealbookingpage.setEnableWalletBalance();
        cateringmealbookingpage.clickSubmittButton();
        cateringmealbookingpage.getSuccessMessage();
        String actualMessage = cateringmealbookingpage.getSuccessMessage();
        System.out.println(actualMessage);
        Assert.assertEquals(
                actualMessage,
                "The items will be delivered to the classroom"
        );
    }
}
