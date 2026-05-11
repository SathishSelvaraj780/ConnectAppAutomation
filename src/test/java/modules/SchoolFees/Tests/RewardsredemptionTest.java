package modules.SchoolFees.Tests;

import base.SeleniumTest;
import modules.SchoolFees.Pages.SchoolFeesPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RewardsredemptionTest extends SeleniumTest {

    @Test
    public void VerifyRewardsRedemption() {
        SchoolFeesPages schoolFees;
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();
        schoolFees = new SchoolFeesPages(driver);
        schoolFees.clickFeePaymentTab();
        schoolFees.clickFeePayment();
        schoolFees.scrollToAmountField();
        schoolFees.enterAmountForStudent1(500);
        schoolFees.moveSliderToMaximum();
        schoolFees.clickProceedToPay();

        // Add assertions to verify rewards redemption functionality
        Assert.assertTrue(
                schoolFees.isFinalProceedToPayDisplayed(),
                "❌ Final Proceed to Pay button is not displayed after selecting rewards redemption"
        );

        System.out.println("TestPassed: Rewards redemption flow is working as expected.");
    }
}
