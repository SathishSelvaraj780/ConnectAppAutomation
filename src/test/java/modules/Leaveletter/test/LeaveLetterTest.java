package modules.Leaveletter.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.SeleniumTest;
import modules.Leaveletter.Page.LeaveLetterPage;
import modules.Leaverequest.Page.LeaveRequestPage;
import modules.login.pages.LoginPage;

public class LeaveLetterTest extends SeleniumTest {
	

	@Test
    public void leaveLetterSubmission() throws InterruptedException {
		
		try
		{
       // Step 1: Launch application
       driver.get(config.getProperty("app.url"));

       // Step 2: Login with credentials from config
       LoginPage Login = new LoginPage(driver);
       Login.enterUsername(config.getProperty("test.username", "Faizal.a9"));
       Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
       Login.clickLogin();
       
       // Wait for login to complete or dashboard to load using explicit wait
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.urlContains("Home/Home"));
       
       // Step 3: Open Leave Request page and submit a new request
       LeaveLetterPage leaveLetter1 = new LeaveLetterPage(driver);
       leaveLetter1.openRequestsMenu();
       leaveLetter1.openLeaveRequestMenu();
       leaveLetter1.selectLeaveLetterTab();
       leaveLetter1.selectArrow();
       Thread.sleep(3000);

wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.id("dropdownList")
));

       leaveLetter1.selectStudentRadioButton();
       Thread.sleep(3000);
       leaveLetter1.selectStatusDropDown();
       leaveLetter1.selectNotAppliedOption();
       leaveLetter1.selectEditOption();
       leaveLetter1.enterComments();
       Thread.sleep(5000);
       leaveLetter1.clickSaveButton();
       // Step 4: Validate Success Message
       String actualMsg = leaveLetter1.getSuccessMessage();
       Assert.assertTrue(actualMsg.contains("Leave request saved successfully"), "Leave request not successful!");
       
		}

		catch (Exception e) {

		        e.printStackTrace();

		        throw e;   
}
}
}

