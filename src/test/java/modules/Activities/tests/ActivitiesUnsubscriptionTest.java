package modules.Activities.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.SeleniumTest;
import modules.Activities.pages.Activities;
import modules.login.pages.LoginPage;

public class ActivitiesUnsubscriptionTest extends SeleniumTest

{

	@Test
	public void appActivities() throws InterruptedException {

		driver.get(config.getProperty("app.url"));

		LoginPage Login = new LoginPage(driver);
		Login.enterUsername(config.getProperty("test.username", "Faizal.a9"));
		Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
		Login.clickLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		System.out.println("Switched to URL: " + driver.getCurrentUrl());
		wait.until(ExpectedConditions.urlContains("Home"));

		Activities Activities1 = new Activities(driver);
		Activities1.openActivitiesMenu();
		Activities1.clickUnsubscribe();
		Activities1.clickUnsubscribeConfirm();
		String actualMsg = Activities1.getSuccessMessage2();
		Assert.assertEquals(actualMsg, "Activity unsubscribed successfully", "Success popup message is incorrect!");
		System.out.println(actualMsg);
		Activities1.clickOk();
		Thread.sleep(3000);
	}

}
