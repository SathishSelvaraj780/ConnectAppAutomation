package modules.StudentProfile.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.StudentProfile.Pages.StudentProfilePage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class OthersTabAchievementTest extends SeleniumTest {
    @Epic("Student Profile")
    @Feature("Achievment Details")
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Student Profile Achievement Details")
    @Test
    public void OthersTabAchievementTest(){
        // Test implementation for Others Tab Achievement details verification
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "MILIND.P5"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        StudentProfilePage studentProfilePage =new StudentProfilePage(driver);
        studentProfilePage.clickStudentProfileTopMenu();
        studentProfilePage.clickOtherTab();
        studentProfilePage.validateAchievementHeaders();
        studentProfilePage.printAchievementTableData();

    }

}
