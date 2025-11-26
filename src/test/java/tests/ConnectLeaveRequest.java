package tests;

import base.SeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeaveRequestPage;
import pages.LoginPage;


public class ConnectLeaveRequest extends SeleniumTest {

    @Test
     public void testLeaveRequestSubmission() throws InterruptedException {
        // Step 1: Launch application
        driver.get(config.getProperty("app.url"));

        // Step 2: Login
    LoginPage Login = new LoginPage(driver);
    Login.enterUsername("shakeel.s22");
    Login.enterPassword("Welcome1234@");
    Login.clickLogin();
        // Optional: wait for login to complete or dashboard to load
        Thread.sleep(3000);
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
