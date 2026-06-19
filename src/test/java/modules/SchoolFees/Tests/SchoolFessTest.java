package modules.SchoolFees.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.SchoolFees.Pages.SchoolFeesPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("School Fee")
@Feature("School Fee Payment")
public class SchoolFessTest extends SeleniumTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user can able to pay School Fee")
    @Test(groups = {"regression"})
    public void VerifySchoolFeesTest() {
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
        //schoolFees.enterAmountForStudent2(500);
        schoolFees.clickProceedToPay();
        schoolFees.waitForProceedButton(wait);
        schoolFees.clickProceedToPay();
        schoolFees.clickFinalProceedToPay();
        // Page Assertion
        wait.until(ExpectedConditions.urlContains("ap-gateway.mastercard.com"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("ap-gateway.mastercard.com"), "❌ URL does not contain expected text after payment process");
    }
}
