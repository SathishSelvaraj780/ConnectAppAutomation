package modules.performance.tests;

import java.time.Duration;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SeleniumTest;
import modules.login.pages.LoginPage;
import modules.performance.pages.PerformanceReport;
@Epic("Reports")
@Feature("Performmance Reports")
public class PerformanceTest extends SeleniumTest

{
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate user can able to view and download performance reports")
	@Test(groups = {"regression"})
	public void appPerformanceReports() throws InterruptedException {

		driver.get(config.getProperty("app.url"));

		LoginPage Login = new LoginPage(driver);
		Login.enterUsername(config.getProperty("test.username", "Faizal.a9"));
		Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
		Login.clickLogin();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("https://qa-connectv2.phoenixhse.com/"));
		PerformanceReport performancereport1 = new PerformanceReport(driver);
		performancereport1.openAcademicsMenu();
		performancereport1.openPerformanceReportsMenu();
		performancereport1.openAcademicYearMenu();
		performancereport1.selectYear("2024-2025");
		performancereport1.waitForPeriodicTest();
		performancereport1.clickPeriodicTestViewReport();

Assert.assertTrue(
		performancereport1.getPerformanceModalTitle().contains("Student Performance Chart"),
    "Text not visible"
);
System.out.println("File Opened Successfully");
		performancereport1.closePdfViewer();
		performancereport1.PeriodicDownloadReport();
		
		
	}
	
}
