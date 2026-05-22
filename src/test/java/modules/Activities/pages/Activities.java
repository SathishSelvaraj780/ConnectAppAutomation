package modules.Activities.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activities {
	
	
	private WebDriver driver;
	private WebDriverWait wait;


	private By Activities = By.xpath("//*[@data-menutext='Activities']");
	private By Enroll = By.xpath("//button[@id='btnEnroll0']");
	private By SendRequest = By.xpath("//button[normalize-space()='Send Request']");
	private By sucessMessage = By.xpath("//p[@class='update-success-msg' and text()='Activity enrollment request was processed successfully']");
	private By Proceed = By.xpath("//button[normalize-space()='Proceed to Pay']");
	private By Confirm = By.xpath("//a[@id='btnconfirm']");
	private By OkButton = By.xpath("//button[normalize-space()='ok']");
	private By Cancel = By.xpath("//button[normalize-space()='Cancel']");
	private By Unsubscribe = By.xpath("//*[name()='svg' and contains(@onclick,'unSubscribePopup')]");
	private By UnsubscribeConfirm = By.xpath("//button[@id='btnconfirm']");
	private By sucessMessage2 = By.xpath("//div[contains(@class,'messageSuccess') and text()='Activity unsubscribed successfully']");
	private By Ok = By.xpath("//button[contains(@class,'success-dialog-ok') and normalize-space()='Ok']");
	
	public Activities(WebDriver driver)

	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}


	public void openActivitiesMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Activities)).click();
	}
	
	public void clickEnrollButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Enroll)).click();
	}
	
	public void clickSendRequest() {
		wait.until(ExpectedConditions.elementToBeClickable(SendRequest)).click();
	}
	
	public String getSuccessMessage() {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(sucessMessage)).getText();
    }
	
	public void clickOkButton() {
		wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
	}
	
	
	public void clickProceedToPay() {
		wait.until(ExpectedConditions.elementToBeClickable(Proceed)).click();
	}
	
	public void clickConfirmAndProceed() {
		wait.until(ExpectedConditions.elementToBeClickable(Confirm)).click();
	}
	
	public void clickCancelButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Cancel)).click();
	}
	
	public void clickUnsubscribe() {
		wait.until(ExpectedConditions.elementToBeClickable(Unsubscribe)).click();
	}
	
	public void clickUnsubscribeConfirm() {
		wait.until(ExpectedConditions.elementToBeClickable(UnsubscribeConfirm)).click();
	}
	
	public String getSuccessMessage2() {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(sucessMessage2)).getText();
    }
	
	public void clickOk() {
		wait.until(ExpectedConditions.elementToBeClickable(Ok)).click();
	}
	
}
