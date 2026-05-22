package modules.StudentProfile.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.StudentProfile.Pages.StudentProfilePage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("Student Profile")
@Feature("Other Details")
public class OthersLibraryUsageTest extends SeleniumTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Student Profile Library Usage Details")
    @Test
    public void validateothersLibraryUsageTest()
    {
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "SALEEL.A7"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        StudentProfilePage studentProfilePage =new StudentProfilePage(driver);
        studentProfilePage.clickStudentProfileTopMenu();
        studentProfilePage.clickOtherTab();
        studentProfilePage.openAccordion("Library");
        studentProfilePage.validateLibraryHeaders();
        studentProfilePage.printLibraryTableData();
    }
}
