package modules.Activities.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.SeleniumTest;
import modules.Activities.pages.Activities;
import modules.academics.pages.AcademicReports;
import modules.login.pages.LoginPage;

	
	public class ActivitiesTest extends SeleniumTest {

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


	wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//*[@data-menutext='Academics']")));

	        Activities Activities1 = new Activities(driver);
	        Activities1.openActivitiesMenu();
	        Thread.sleep(4000);
		}
	
	}

