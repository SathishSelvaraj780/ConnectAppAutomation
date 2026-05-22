package modules.StudentProfile.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.StudentProfile.Pages.StudentProfilePage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
@Epic("Student Profile")
@Feature(" FeeDetails")
public class FeeDetailsTest extends SeleniumTest {
    @Story("Validate Fee Details Page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Student Profile Fee Details")
    @Test
    public void VerifyFeeDetailsPage(){
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        StudentProfilePage studentProfilePage =new StudentProfilePage(driver);
        studentProfilePage.clickStudentProfileTopMenu();
        studentProfilePage.clickFeeDetailsTab();
        Assert.assertTrue( studentProfilePage.validateFieldAndValue(
                "Fee Description",
                "Tuition Fee"));
        studentProfilePage.openAccordion("Payment History");
        Assert.assertTrue(
                studentProfilePage.validateTableHeader(
                        "Receipt Date"));

        Assert.assertTrue(
                studentProfilePage.validateTableHeader(
                        "Receipt Number"));

        Assert.assertTrue(
                studentProfilePage.validateTableHeader(
                        "Narration"));

    }

}
