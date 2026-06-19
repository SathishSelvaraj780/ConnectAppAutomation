package modules.SchoolFees.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.SchoolFees.Pages.SchoolFeesPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("School Fee")
@Feature("School Fee Payment")
public class RewardsredemptionTest extends SeleniumTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user can able to pay School Fee through Reward Points")
    @Test(groups = {"regression"})
    public void VerifyRewardsRedemption() {
        SchoolFeesPages schoolFees;
        getDriver().get(config.getProperty("app.url"));
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
