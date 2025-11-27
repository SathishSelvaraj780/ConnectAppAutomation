package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransportPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By Topmenu = By.xpath("//*[@data-menutext='Requests']");
    private By TransportMenu = By.xpath("//li[@data-menu='Transport']");
    private By ServiceRequest = By.xpath("//*[@data-menutext=\"Service Request\"]");
    private By Category = By.xpath("//*[@id=\"categorySelect\"]");
    private By DescriptionField = By.xpath("//*[@id=\"txtcomment\"]");
    private By ContactedButtonYes = By.xpath("//*[@id=\"contactYes\"]");
    private By ContactedButtonNo = By.xpath("//*[@id=\"contactNo\"]");
    private By HowToConatc = By.xpath("//input[@type=\"radio\" and @value=\"Mobile\"]");
    private By Attachment  = By.xpath("//input[@id=\"file-input\"]");
    private By SubmittButton = By.id("submitServiceRequest");
    private By CancelButton = By.id("cancelToHome");
    private By ConfirmationPopupYes = By.id("yesButton");
    private By ConfirmationPopupNo =By.id("noButton");
    private By sucessButton = By.xpath("//*[@id=\"SaveServiceRequestPopup\"]/div/div/div/div[3]/div/button");
    private By sucessMessage = By.xpath("//*[@id=\"SaveServiceRequestMessage\"]");
    public TransportPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        //Open Catering Menu
        public void openTransport(){
            wait.until(ExpectedConditions.elementToBeClickable(TransportMenu)).click();
        }
        //Open Service request
    public void openServiceRequest(){
        wait.until((ExpectedConditions.elementToBeClickable(ServiceRequest))).click();
    }
    public void selectCategory(){
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Category));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Record Medical Condition");
    }
    //Enter description
    public void enterDescription(String description){
        driver.findElement(DescriptionField).sendKeys(description);
    }
    //Select Would like to be Contacted
    public void selectwouldlikeTobeContacted(){
            driver.findElement(ContactedButtonNo).click();
    }
    //Select How to be Contacted
    public void slectHowtobeContacted(){
        driver.findElement(HowToConatc).click();
    }
    // Upload attachment (file upload)

    public void uploadAttachment(String filePath) {
        WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(Attachment));
        upload.sendKeys(filePath); // Direct file path upload
    }
    public void selectSubmit(){
        driver.findElement(SubmittButton).click();
    }
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(sucessMessage)).getText();
    }
    public void clickSuccessOk() {
        wait.until(ExpectedConditions.elementToBeClickable(sucessButton)).click();
    }
    }

