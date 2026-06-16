package modules.Leaveletter.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeaveLetterPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private By Topmenu = By.xpath("//*[@data-menutext='Requests']");
	private By Leavemenu = By.xpath("//*[@data-menutext='Leave Request/Letter']");
	private By Leavelettertab = By.xpath("//a[normalize-space()='Leave Letter']");
	private By ClickEdit = By.xpath("//a[@data-original-title='Edit']");
	private By CommentField = By.xpath("//textarea[@id='remarksLN']");
	private By SaveButton = By.xpath("//button[@onclick='saveLeaveLetter()']");
	private By successMessage = By.xpath("//*[@id=\"success-dialog\"]/div/div/div[2]/div[2]");

	// Constructor
	public LeaveLetterPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void openRequestsMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Topmenu)).click();
	}

	public void openLeaveRequestMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Leavemenu)).click();
	}


public void selectLeaveLetterTab() {

    // Wait for overlay to disappear
    wait.until(ExpectedConditions.invisibilityOfElementLocated(
        By.xpath("//div[contains(@class,'blockOverlay')]")
    ));

    // Then click
    wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[normalize-space()='Leave Letter']")
    )).click();
}



public void selectArrow() {
    WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(
        By.id("selectedItem")
    ));
    arrow.click();
}


public void selectStudentRadioButton() {


	// wait for dropdown
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdownList")));

	    // ✅ click dropdown item (THIS triggers student change)
	    WebElement student = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("(//div[@id='dropdownList']//div[contains(@class,'dropdown-item')])[2]")
	    ));

	    student.click();


}



public void selectStatusDropDown() {

	// ✅ wait for overlay to disappear
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	        By.xpath("//div[contains(@class,'blockOverlay')]")
	    ));

	    // ✅ then click dropdown
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[contains(@class,'filter-option-inner-inner')]")
	    )).click();

}

	public void selectNotAppliedOption()

	{

WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//*[text()='Not Applied']")
));
option.click();


	}

	public void selectEditOption()

	{
		wait.until(ExpectedConditions.elementToBeClickable(ClickEdit)).click();

	}

	public void enterComments()

	{
		wait.until(ExpectedConditions.elementToBeClickable(CommentField)).click();

WebElement commentBox = wait.until(
        ExpectedConditions.elementToBeClickable(CommentField)
    );

    commentBox.sendKeys("I was not well"); // ✅ enter text


	}
	

public void clickSaveButton() {

    WebElement save = wait.until(ExpectedConditions.elementToBeClickable(SaveButton));

    save.click();
}

 public String getSuccessMessage() {
	WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	return msg.getText();
	 }
}
