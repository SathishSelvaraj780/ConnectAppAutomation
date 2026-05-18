package modules.StudentProfile.Tests;

import base.SeleniumTest;
import io.qameta.allure.Description;
import modules.StudentProfile.Pages.StudentProfilePage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CurriculamTest extends SeleniumTest
{
    @Description("Validate Student Profile Curriculam Details")
    @Test
    public void VerifyCurriculamDetailsPage()
    {
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        StudentProfilePage studentProfilePage =new StudentProfilePage(driver);
        studentProfilePage.clickStudentProfileTopMenu();
        studentProfilePage.clickCurriculamTab();
        Assert.assertTrue( studentProfilePage.validateFieldAndValue(
                "Subject",
                "Artificial Intelligence"));
        Assert.assertTrue( studentProfilePage.validateFieldAndValue("Teacher","Shriyaa Vishnu Amin"));
        Assert.assertTrue( studentProfilePage.validateFieldAndValue("Email","20514@testemail.com"));
        }
}
