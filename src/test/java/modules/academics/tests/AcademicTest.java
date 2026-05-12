package modules.academics.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SeleniumTest;
import modules.academics.pages.AcademicReports;
import modules.login.pages.LoginPage;

public class AcademicTest extends SeleniumTest {

	@Test
	public void appAcademicReports() throws InterruptedException {

		driver.get(config.getProperty("app.url"));

		LoginPage Login = new LoginPage(driver);
		Login.enterUsername(config.getProperty("test.username", "Faizal.a9"));
		Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
		Login.clickLogin();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("https://qa-connectv2.phoenixhse.com/"));
		AcademicReports academicreport1 = new AcademicReports(driver);
		
		
		academicreport1.openAcademicsMenu();
		academicreport1.openAcademicReportsMenu();
		academicreport1.openAcademicYearMenu();
		academicreport1.selectYear("2023-2024");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='name' and normalize-space()='Cat4 Reports']")));

		academicreport1.clickCat4ViewReport();
		academicreport1.closePdfViewer();
		academicreport1.clickCat4DownloadReport();
	

	}

}
