package modules.Homepage.DashboardTests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.Homepage.DashboardPages.DashboardRedirectionPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Epic("Homepage")
@Feature("Redirections")
public class DashboardRedirectionTest extends SeleniumTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate user can able to redirect to all appropriate pages from the dashboard")
    @Test(groups = {"sanity", "regression"})
    public void verifyAllDashboardRedirections() {

        getDriver().get(config.getProperty("app.url"));
        DashboardRedirectionPages dashboard ;
        LoginPage login = new LoginPage(getDriver());
        login.enterUsername(config.getProperty("test.username", "shakeel.s22"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        dashboard = new DashboardRedirectionPages(getDriver());

        Assert.assertTrue(dashboard.goToActivities(), "Activities redirection failed");
        getDriver().navigate().back();

        Assert.assertTrue(dashboard.goToLeaveRequest(), "Leave Request redirection failed");
        getDriver().navigate().back();

        Assert.assertTrue(dashboard.goToProfileCompletion(), "Profile redirection failed");
        getDriver().navigate().back();

        Assert.assertTrue(dashboard.goToSchoolFee(), "School Fee redirection failed");
        getDriver().navigate().back();

        Assert.assertTrue(dashboard.goToTransportFee(), "Transport Fee redirection failed");
        getDriver().navigate().back();

        Assert.assertTrue(dashboard.goToAttendance(), "Attendance redirection failed");
        getDriver().navigate().back();
    }
}

