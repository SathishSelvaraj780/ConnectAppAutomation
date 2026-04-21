package tests;

import base.SeleniumTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeaveRequestPage;
import pages.LoginPage;

import java.time.Duration;


public class ConnectLeaveRequest extends SeleniumTest {

    @Test
     public void testLeaveRequestSubmission() throws InterruptedException {
        // Step 1: Launch application
        driver.get(config.getProperty("app.url"));

        // Step 2: Login with credentials from config
        LoginPage Login = new LoginPage(driver);
        Login.enterUsername(config.getProperty("test.username", "shakeel.s22"));
        Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        Login.clickLogin();
        
        // Wait for login to complete or dashboard to load using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("Home/Home"));
        
        // Step 3: Open Leave Request page and submit a new request
        LeaveRequestPage leaveRequestPage = new LeaveRequestPage(driver);
        leaveRequestPage.openRequestsMenu();
        leaveRequestPage.openLeaveRequestMenu();
        leaveRequestPage.clickApplyLeave();
        leaveRequestPage.selectFromDate("30");
        leaveRequestPage.selectToDate("30");
        leaveRequestPage.selectReason("Illness");
        leaveRequestPage.enterComments("Not feeling well");
        leaveRequestPage.clickSave();

        // Step 4: Validate Success Message
        String actualMsg = leaveRequestPage.getSuccessMessage();
        Assert.assertTrue(actualMsg.contains("Leave request saved successfully"), "Leave request not successful!");
}
}
