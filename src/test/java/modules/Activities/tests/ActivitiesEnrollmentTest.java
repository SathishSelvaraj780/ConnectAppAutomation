package modules.Activities.tests;

import java.time.Duration;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.SeleniumTest;
import modules.Activities.pages.Activities;
import modules.academics.pages.AcademicReports;
import modules.login.pages.LoginPage;
@Epic("Activities")
@Feature("Enroll to Activity")
public class ActivitiesEnrollmentTest extends SeleniumTest {
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate user can able to enroll for activities and proceed to payment page")
	@Test(groups = {"regression"})
	public void appActivities() throws InterruptedException {

		getDriver().get(config.getProperty("app.url"));

		LoginPage Login = new LoginPage(driver);
		Login.enterUsername(config.getProperty("test.username", "Faizal.a9"));
		Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
		Login.clickLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		System.out.println("Switched to URL: " + driver.getCurrentUrl());
		wait.until(ExpectedConditions.urlContains("Home"));

		Activities Activities1 = new Activities(driver);
		Activities1.openActivitiesMenu();
		Activities1.clickEnrollButton();
		Activities1.clickSendRequest();
		String actualMsg = Activities1.getSuccessMessage();
		Assert.assertEquals(actualMsg, "Activity enrollment request was processed successfully",
				"Success popup message is incorrect!");
		Activities1.clickOkButton();
		Activities1.clickProceedToPay();
		Activities1.clickConfirmAndProceed();
		wait.until(ExpectedConditions.urlContains("ap-gateway.mastercard.com"));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("ap-gateway.mastercard.com"),
				"URL does not contain expected text after payment process");
		Thread.sleep(3000);
	}

}
