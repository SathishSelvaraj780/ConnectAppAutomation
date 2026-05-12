package modules.academics.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.SeleniumTest;

public class AcademicReports extends SeleniumTest

{

	private By Academics = By.xpath("//*[@data-menutext='Academics']");
	private By AcademicReports = By.xpath("//*[@data-menutext='Academic Reports']");
	private By AcademicYear = By.xpath("//button[@data-id='selectedAcademicYears']");
	private By cat4ViewReport = By.xpath("//div[@class='name' and normalize-space()='Cat4 Reports']"
			+ "/following::a[normalize-space()='View Report'][1]");
	private By cat4DownloadReport = By.xpath("//div[@class='name' and normalize-space()='Cat4 Reports']"
			+ "/following::a[normalize-space()='Download'][1]");
	

	public AcademicReports(WebDriver driver)

	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void openAcademicsMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Academics)).click();
	}

	public void openAcademicReportsMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(AcademicReports)).click();
	}

	public void openAcademicYearMenu() {
		waitForOverlayToDisappear();
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

	public void waitForCat4Card() {
		By cat4Text = By.xpath("//div[normalize-space()='Cat4 Reports']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cat4Text));
	}

	public void clickCat4ViewReport() {
		wait.until(ExpectedConditions.elementToBeClickable(cat4ViewReport)).click();
	}

	public void closePdfViewer() {

	    By modal = By.id("report-dialog");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

	    // Step 1 — Switch into the iframe once
	    By frame = By.id("pdf-viewer");
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

	    // Small pause for PDF load
	    new WebDriverWait(driver, Duration.ofSeconds(2));

	    // Step 2 — Come back to main DOM
	    driver.switchTo().defaultContent();

	    // Step 3 — Now click the close button
	    By closeBtn = By.xpath("//div[@id='report-dialog']//a[@data-dismiss='modal']");
	    WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeBtn));

	    close.click();

	    // Step 4 — Wait modal disappear
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
	}
	
	public void clickCat4DownloadReport() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(cat4DownloadReport)).click();
		Thread.sleep(8000);
	}
	
}