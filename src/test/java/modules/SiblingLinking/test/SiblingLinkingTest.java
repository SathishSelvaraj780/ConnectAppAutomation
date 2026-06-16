package modules.SiblingLinking.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.SeleniumTest;
import modules.Leaveletter.Page.LeaveLetterPage;
import modules.SiblingLinking.Page.SiblingLinkingPage;
import modules.login.pages.LoginPage;

public class SiblingLinkingTest extends SeleniumTest
{

	@Test
    public void SiblingLinkingSubmission() throws InterruptedException {
		
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
       SiblingLinkingPage SiblingLinking1 = new SiblingLinkingPage(driver);
       SiblingLinking1.openRequestsMenu();
       SiblingLinking1.openSiblingLinkingMenu();
       Thread.sleep(5000);
       SiblingLinking1.enterEmailId();
       SiblingLinking1.enterStudentId();
       SiblingLinking1.enterDOB();
       SiblingLinking1.clickSubmit();
       Thread.sleep(5000);

	}

	catch (Exception e) {

	        e.printStackTrace();

	        throw e;   
}
}
}