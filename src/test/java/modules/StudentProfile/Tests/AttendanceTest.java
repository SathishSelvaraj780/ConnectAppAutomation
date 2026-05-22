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
@Feature("Attendence Details")
public class AttendanceTest extends SeleniumTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Student Profile Attendance Details")
    @Test
    public void verifyAttendanceDetails() {
        // Test implementation for attendance details verification
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        StudentProfilePage studentProfilePage =new StudentProfilePage(driver);
        studentProfilePage.clickStudentProfileTopMenu();
        studentProfilePage.clickAttendanceTab();
        Assert.assertTrue( studentProfilePage.validateDynamicFieldValue("Days Present"));
        Assert.assertTrue( studentProfilePage.validateDynamicFieldValue("Authorized Leave"));
        Assert.assertTrue( studentProfilePage.validateDynamicFieldValue("Overall attendance %"));
        studentProfilePage.openAccordion("Attendance Graph By Month");
        Assert.assertTrue(
                studentProfilePage.validateGraphPresent(
                        "attendance-graph-by-month"));
        studentProfilePage.openAccordion("Attendance Graph By Weekly Absent/Late Pattern");
        Assert.assertTrue(
                studentProfilePage.validateGraphPresent(
                        "attendance-graph-by-weekly-late"));

    }

}
