package modules.Homepage.DashboardTests;

import base.SeleniumTest;
import modules.Homepage.DashboardPages.DashboardRedirectionPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class DashboardRedirectionTest extends SeleniumTest {
    @Test
    public void verifyAllDashboardRedirections() {
        DashboardRedirectionPages dashboard ;

        driver.get(config.getProperty("app.url"));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "shakeel.s22"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        dashboard = new DashboardRedirectionPages(driver);

        Assert.assertTrue(dashboard.goToActivities(), "Activities redirection failed");
        driver.navigate().back();

        Assert.assertTrue(dashboard.goToLeaveRequest(), "Leave Request redirection failed");
        driver.navigate().back();

        Assert.assertTrue(dashboard.goToProfileCompletion(), "Profile redirection failed");
        driver.navigate().back();

        Assert.assertTrue(dashboard.goToSchoolFee(), "School Fee redirection failed");
        driver.navigate().back();

        Assert.assertTrue(dashboard.goToTransportFee(), "Transport Fee redirection failed");
        driver.navigate().back();

        Assert.assertTrue(dashboard.goToAttendance(), "Attendance redirection failed");
        driver.navigate().back();
    }
}

