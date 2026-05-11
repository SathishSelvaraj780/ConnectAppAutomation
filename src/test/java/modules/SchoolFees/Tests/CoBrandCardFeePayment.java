package modules.SchoolFees.Tests;

import base.SeleniumTest;
import modules.SchoolFees.Pages.SchoolFeesPages;
import modules.catering.pages.CateringTopUp;
import modules.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CoBrandCardFeePayment extends SeleniumTest {

    @Test
    public void VerifyCoBrandCardFeePayment() {

        driver.get(config.getProperty("app.url"));

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        LoginPage login = new LoginPage(driver);

        login.enterUsername(
                config.getProperty("test.username", "faizal.a9"));

        login.enterPassword(
                config.getProperty("test.password", "Welcome1234@"));

        login.clickLogin();

        SchoolFeesPages schoolFees =
                new SchoolFeesPages(driver);

        schoolFees.clickFeePaymentTab();
        schoolFees.clickFeePayment();
        schoolFees.clickWhenReady(By.xpath("//*[contains(@onclick, \"SetCardClass(this,'93SoG4LU7nk=')\")]"));
        schoolFees.scrollToAmountField();
        schoolFees.enterAmountForStudent1(500);
        schoolFees.clickProceedToPay();
        schoolFees.waitForProceedButton(wait);
        schoolFees.clickProceedToPay();
        schoolFees.clickFinalProceedToPay();

        wait.until(ExpectedConditions.urlContains(
                "ap-gateway.mastercard.com"));

        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                actualUrl.contains("ap-gateway.mastercard.com"),
                "❌ URL does not contain expected text after payment process");

        System.out.println(
                "✅ Co-brand card fee payment flow is working as expected.");
    }
}