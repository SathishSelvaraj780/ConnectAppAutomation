package modules.StudentProfile.Tests;

import base.SeleniumTest;
import io.qameta.allure.Description;
import modules.StudentProfile.Pages.StudentProfilePage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ComminicationsTest extends SeleniumTest {

    @Description("Validate Student Profile Communications Details")
    @Test
    public void validateAllMessageAccordions() throws InterruptedException {

        driver.get(config.getProperty("app.url"));

        LoginPage login = new LoginPage(driver);

        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));

        login.clickLogin();

        StudentProfilePage studentProfilePage =
                new StudentProfilePage(driver);
        studentProfilePage.clickStudentProfileTopMenu();
        studentProfilePage.clickCommunicationsTab();
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Title"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Type"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Email ID"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Delivery Status"));
        studentProfilePage.clickCommandNewsLetterArrorw();
        Assert.assertTrue(studentProfilePage.isCommunicationMessageDisplayed());
        studentProfilePage.openAccordion("Message Details");
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Message (SMS)"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Mobile Number"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Sent On"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Delivery Status"));
        studentProfilePage.clickMessageDetailsarrow();
        Assert.assertTrue(studentProfilePage.isCommunicationMessageDisplayed());
        studentProfilePage.openAccordion("Alerts / Notifications");
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Message"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Category"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Type"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Sent On"));
        Assert.assertTrue(studentProfilePage.validateDynamicFieldValue("Status"));
    }
}
