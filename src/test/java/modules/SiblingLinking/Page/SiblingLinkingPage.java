package modules.SiblingLinking.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiblingLinkingPage 
{

	private WebDriver driver;
	private WebDriverWait wait;

	private By Topmenu = By.xpath("//*[@data-menutext='Requests']");
	private By SiblingLinkingMenu = By.xpath("//*[@data-menutext='Link Sibling']");
	private By EmailIdField = By.xpath("//input[@id='email']");
	private By StudentIdField = By.xpath("//input[@id='studno']");
	private By validationMessage = By.xpath("//*[@id=\"success-dialog\"]/div/div/div[2]/div[2]");
	
	

	// Constructor
	public SiblingLinkingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void openRequestsMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Topmenu)).click();
	}
	
	public void openSiblingLinkingMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(SiblingLinkingMenu)).click();
	}
	
	
	public void enterEmailId() {
		wait.until(ExpectedConditions.elementToBeClickable(EmailIdField)).sendKeys("test_F20899423@testemail.com");
	}
	
	public void enterStudentId() {
		wait.until(ExpectedConditions.elementToBeClickable(StudentIdField)).sendKeys("11500202021241");
	}
	
	public void enterDOB()
	
	{

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("document.getElementById('dob').value='12/Feb/2010';");

	}
	
  public void clickSubmit()
	
	{
	  driver.findElement(By.id("btnSend")).click();
		
	}
	
}
