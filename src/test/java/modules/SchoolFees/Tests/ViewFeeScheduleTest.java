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
public class ViewFeeScheduleTest extends SeleniumTest {

            @Severity(SeverityLevel.NORMAL)
            @Description("Validate user can able to view School Fee Schedules")
            @Test
            public void VerifySchoolFeeSchedulePopUpDisplayed   () {
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
                schoolFees.clickViewSchedule();
                // popup Assertion
                Assert.assertTrue(
                        schoolFees.isSchedulePopupDisplayed(),
                        "❌ Schedule popup is not displayed"
                );
            }
}

