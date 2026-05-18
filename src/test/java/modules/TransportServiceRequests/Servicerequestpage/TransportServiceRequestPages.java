package modules.TransportServiceRequests.Servicerequestpage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransportServiceRequestPages {

    private WebDriver driver;
    private WebDriverWait wait;

    // Removed unused: private By Topmenu = By.xpath("//*[@data-menutext='Requests']");
    private By TransportMenu = By.xpath("//li[@data-menu='Transport']");
    private By ServiceRequest = By.xpath("//*[@data-menutext=\"Service Request\"]");
    private By Category = By.xpath("//*[@id=\"categorySelect\"]");
    private By DescriptionField = By.xpath("//*[@id=\"txtcomment\"]");
    private By ContactedButtonNo = By.xpath("//*[@id=\"contactNo\"]");
    private By HowToContact = By.xpath("//input[@type=\"radio\" and @value=\"Mobile\"]");
    private By Attachment  = By.xpath("//input[@id=\"file-input\"]");
    private By SubmittButton = By.id("submitServiceRequest");
    private By CancelButton = By.id("cancelToHome");
    private By ConfirmationPopupYes = By.id("yesButton");
    private By ConfirmationPopupNo =By.id("noButton");
    private By sucessButton = By.xpath("//*[@id=\"SaveServiceRequestPopup\"]/div/div/div/div[3]/div/button");
    private By sucessMessage = By.xpath("//*[@id=\"SaveServiceRequestMessage\"]");
    private By selectTypeDropdoen = By.id("idType");
    private By ProceedtoPay = By.xpath("//button[@id=\"proceedToPay\"]");
    private By SingleDayRequestButton = By.xpath("//a[contains(text(),'Single-Day Schedule Customisation Request')]");
    private By DateSelection =By.xpath("//input[contains(@class,'date-picker')]");
    private By SelectPickupordrop = By.xpath("//*[@id='transportType']");
    private By EnterRemarks = By.xpath("//*[@id=\"textAreaDescription\"]");
    private By clickSaveButton = By.xpath("//button[contains(@onclick,\"submitScheduleForm()\")]");
    private By RecordSavedText = By.xpath("//div[@id=\"successMessageChange\"]");
    private By OktoRedirect = By.xpath("//button[@id=\"redirectButton\"]");
    private By calendarIcon = By.xpath("//*[@class=\"calender-icon mCS_img_loaded\"]");


    public TransportServiceRequestPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        //Open Transport Menu
        public void openTransport(){
            wait.until(ExpectedConditions.elementToBeClickable(TransportMenu)).click();
        }
        //Open Service request
    public void openServiceRequest(){
        wait.until(ExpectedConditions.elementToBeClickable(ServiceRequest)).click();
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
    public void selectWouldLikeToBeContacted(){
            driver.findElement(ContactedButtonNo).click();
    }
    //Select How to be Contacted
    public void selectHowToBeContacted(){
        driver.findElement(HowToContact).click();
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
    public void selectRFIDCard() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Category));
        Select select = new Select(dropdown);
        select.selectByVisibleText("RFID");
    }

    public void selectIDType() {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(selectTypeDropdoen));

        Select select = new Select(dropdown);

        select.selectByVisibleText("ID card only (Fee - 10 AED)");
    }
    public void clickProceedtopay() {
    wait.until(ExpectedConditions.elementToBeClickable(ProceedtoPay)).click();
    }
    public void selectSingleDayRequestButton() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Category));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Single-Day Schedule Customisation Request");
    }
    public void clickSingleDayRequestButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SingleDayRequestButton)).click();
    }
    public void selectDateSelection() {
        WebElement dateField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(calendarIcon));

        // Wait small time for JS rendering
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);

        actions.moveToElement(dateField)
                .click()
                .perform();

        By currentDate = By.xpath(
                "//td[contains(@class,'day') and not(contains(@class,'disabled'))]");

        WebElement date = wait.until(
                ExpectedConditions.visibilityOfElementLocated(currentDate));

        actions.moveToElement(date)
                .click()
                .perform();
     }
     public void setSelectPickupordrop(){
         WebElement dropdown = wait.until(
                 ExpectedConditions.elementToBeClickable(SelectPickupordrop));

         Select select = new Select(dropdown);

         select.selectByVisibleText("No Bus Transport");
     }
     public void setEnterRemarks(String remarks) {
        driver.findElement(EnterRemarks).sendKeys(remarks);
     }
     public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickSaveButton)).click();
     }
     public String selectRecordSavedText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RecordSavedText)).getText();
     }
     public void OktoRedirect() {
        wait.until(ExpectedConditions.elementToBeClickable(OktoRedirect)).click();
     }

    public void selectOthersCategory(){
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Category));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Other");
    }
    }


