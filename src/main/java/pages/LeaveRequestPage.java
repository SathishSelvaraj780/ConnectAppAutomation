package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LeaveRequestPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Leave Request Locators
    private By Topmenu = By.xpath("//*[@data-menutext='Requests']");
    private By Leavemenu = By.xpath("//*[@data-menutext='Leave Request/Letter']");
    private By ApplyButton = By.id("btnLeave");
    private By fromDateInput = By.xpath("//*[@id='upload_popup']//form//div[1]//div[1]//img");
    private By toDateInput = By.xpath("//*[@id='upload_popup']//form//div[1]//div[2]//img");
    private By fromdatecalendarMonthHeader = By.xpath("//*[@id=\"fromDateReq\"]");
    private By todatecalenderMonthHearder = By.xpath("//*[@id=\"toDateReq\"]");
    private By nextMonthButton = By.xpath("//*[@class='next']");
    private String dayXpath = "//table//td[normalize-space(text())='%s']";
    private By ReasonForLeave = By.xpath("//*[@id=\"upload_popup\"]/div/div/div[2]/div/div/form/div[2]/div/div/div/button/div/div/div");
    private By CommentField = By.xpath("//textarea[@id='remarks1']");
    private By SaveButton = By.xpath("//*[@id='upload_popup']//button[normalize-space()='Save']");
    private By successMessage = By.xpath("//*[@id=\"success-dialog\"]/div/div/div[2]/div[2]");

    // Constructor
    public  LeaveRequestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public  void openRequestsMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(Topmenu)).click();
    }

    public  void openLeaveRequestMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(Leavemenu)).click();
    }

    public void clickApplyLeave() {
        wait.until(ExpectedConditions.elementToBeClickable(ApplyButton)).click();
    }
    public void selectFromDate(String day){
        driver.findElement(fromDateInput).click();
        By dayLocator = By.xpath(String.format(dayXpath, day));
        wait.until(ExpectedConditions.elementToBeClickable(dayLocator)).click();
    }

    public void selectToDate(String day){
        driver.findElement(toDateInput).click();
        By dayLocator = By.xpath(String.format(dayXpath, day));
        wait.until(ExpectedConditions.elementToBeClickable(dayLocator)).click();
    }

    public void selectReason(String reason) {
        // Click the dropdown to open
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(ReasonForLeave));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

        // Build dynamic XPath based on the reason text
        By optionLocator = By.xpath("//a[@role='option']//span[normalize-space(text())='" + reason + "']");

        // Wait for and click the desired option
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }


    public void enterComments(String comment) {
        driver.findElement(CommentField).sendKeys(comment);
    }

    public void clickSave() {
        driver.findElement(SaveButton).click();
    }

    public String getSuccessMessage() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return msg.getText();
    }

}