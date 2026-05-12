package modules.performance.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.SeleniumTest;

public class PerformanceReport extends SeleniumTest

{
	private By Academics = By.xpath("//*[@data-menutext='Academics']");
	private By PerformanceReports = By.xpath("//*[@data-menutext='Performance Reports']");
	private By AcademicYear = By.xpath("//button[@data-id='selectedAcademicYears']");
	private By PeriodicTestViewReport = By.xpath(
		    "//div[normalize-space()='Periodic Test 1']/following::a[1]"
		);
	private By PeriodicDownloadReport = By.xpath("//div[@class='name' and normalize-space()='Periodic Test 1']"
			+ "/following::a[normalize-space()='Download'][1]");
	
	
	public PerformanceReport(WebDriver driver)

	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void openAcademicsMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Academics)).click();
	}
	
	public void openPerformanceReportsMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(PerformanceReports)).click();
	}
	
	public void openAcademicYearMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(AcademicYear)).click();
	}
	
	public void selectYear(String year) {

		wait.until(ExpectedConditions.elementToBeClickable(AcademicYear)).click();
		By yearLocator = By
				.xpath("//div[contains(@class,'dropdown-menu') and contains(@class,'show')]//a[normalize-space()='"
						+ year + "']");

		wait.until(ExpectedConditions.elementToBeClickable(yearLocator)).click();
		waitForOverlayToDisappear();
	}
	
	public void waitForPeriodicTest() {
		By PeriodicTest = By.xpath("//div[normalize-space()='Periodic Test 1']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(PeriodicTest));
	}
	
	public void clickPeriodicTestViewReport() {
		wait.until(ExpectedConditions.elementToBeClickable(PeriodicTestViewReport)).click();
	}
	
	public void closePdfViewer() {

	    By modal = By.id("performance_test_popup");

	    // Wait for modal to appear
	    wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

	    // Click on close button inside modal
	    By closeBtn = By.xpath("//div[@id='performance_test_popup']//a[@data-dismiss='modal']");
	    wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();

	    // Wait for modal to disappear
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
	}
	
	public void PeriodicDownloadReport() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(PeriodicDownloadReport)).click();
		Thread.sleep(8000);
	}
}


