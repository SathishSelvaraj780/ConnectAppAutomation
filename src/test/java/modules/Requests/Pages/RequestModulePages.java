package modules.Requests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class RequestModulePages {


    private By RequestTopMenu = By.xpath("//*[@data-menutext='Requests']");
    private By UploadPhotoMenu = By.xpath("//a[@data-menutext=\"Upload photo\"]");

    private By getUploadButton(String memberType) {
        return By.xpath(String.format("//button[contains(@onclick,'%s')]", memberType.toUpperCase()));
    }
    private By UploadButton = By.xpath("//button[contains(@onclick,\"UploadPhotoToServer()\")]");
    private By ChooseFileButton = By.xpath("//input[@type='file']");
    private By SuccessPopupOkButton = By.xpath("//div[@id='success-dialog']//button");
    private By GatePassTab = By.xpath("//a[@data-menutext=\"Gate Pass\"]");
    private By RequestGatePassButton = By.xpath("//button[contains(@onclick,'showPopupNew()')]");
    private By ChildSelectDropdown = By.xpath("//button[contains(@class,'multiselect')]");
    private By selectChildCheckbox(String childname) {
        return By.xpath("//label[normalize-space()='" + childname + "']/preceding-sibling::input");
    }
    private By DateFieldSelection = By.xpath("//*[@id=\"GPM_REQUEST_DATETIME\"]");
    private By IDTypeDropdown = By.xpath("(//div[contains(@class,'filter-option-inner-inner')])[3]");
    private By IDNumberField = By.xpath("//input[@id=\"GPM_ISSUE_EID\"]");
    private By PassportExpiryDateField = By.xpath("//input[@id=\"GPM_ISSUE_EID_XPIRY\"]");
    private By GatepassSubmittButton = By.xpath("//button[@id=\"btnSaveGPReq\"]");
    private By selectReason = By.xpath("//*[@id=\"GPM_COMMENTS\"]");
    private By gatePassSuccessMessage = By.xpath("//div[contains(@class,'messageSuccess')]");
    private By gatePassOkButton = By.xpath("//button[@class=\"button filter success-dialog-ok\"]");
    private By currentDate(String day) {
        return By.xpath("//td[@data-date='" + day + "']");
    }
    private By selectTime(String time) {
        return By.xpath("//div[contains(@class,'xdsoft_time') and contains(text(),'" + time + "')]");
    }
    private By selectIDTypeOption(String idType) {

        return By.xpath("//div[contains(@class,'dropdown-menu')]//*[normalize-space()='"
                + idType +
                "']");
    }
    private By selectExpiryDate(String day) {
        return By.xpath("//td[contains(@class,'day') and not(contains(@class,'old')) and not(contains(@class,'new')) and text()='" + day + "']");
    }
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RequestModulePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
    }

    public void openRequestMenu() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(RequestTopMenu)).click();
    }

    public void openUploadPhotoMenu() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(UploadPhotoMenu)).click();
    }

    public void clickUploadButton(String memberType) {

        wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .elementToBeClickable(getUploadButton(memberType))
        ).click();
    }

    public void uploadPhoto(String memberType, String filePath) {
        clickUploadButton(memberType);
        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(ChooseFileButton));
        uploadInput.sendKeys(filePath);
        wait.until(driver -> !uploadInput.getAttribute("value").isEmpty());
        WebElement uploadBtn = wait.until(ExpectedConditions.elementToBeClickable(UploadButton));
        uploadBtn.click();
        System.out.println(memberType + " upload completed");
        try {

            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupOkButton));

            okButton.click();

            wait.until(ExpectedConditions.invisibilityOf(okButton));

        } catch (Exception e) {

            System.out.println("Popup not displayed");
        }
    }
        public void openGatepassmenu(){
            wait.until(ExpectedConditions.elementToBeClickable(GatePassTab)).click();
        }
        public void clickRequestGatepass(){
            wait.until(ExpectedConditions.elementToBeClickable(RequestGatePassButton)).click();
        }
        public void clickSelectChildDropdown(){
            WebElement dropdown= wait.until(ExpectedConditions.elementToBeClickable(ChildSelectDropdown));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
        }
        public void selectChild(String childname){
            WebElement checkbox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            selectChildCheckbox(childname)));

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].checked=true;" +
                            "arguments[0].dispatchEvent(new Event('change'));",
                    checkbox);

        }
        public void selectDateandTime(){
            wait.until(ExpectedConditions.elementToBeClickable(DateFieldSelection)).click();
        }
        public void CHooseCurrentDateandTime(String day, String time) {
            wait.until(ExpectedConditions
                            .elementToBeClickable(currentDate(day)))
                    .click();

            WebElement timeSlot = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            selectTime(time)));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", timeSlot);

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", timeSlot);
        }

        public void selectIDType(String idType) {
            wait.until(ExpectedConditions
                            .elementToBeClickable(IDTypeDropdown))
                    .click();

            List<WebElement> allOptions = driver.findElements(
                    By.xpath("//*[contains(text(),'Emirates')]"));

            System.out.println("Options Size : " + allOptions.size());

            for(WebElement option : allOptions){

                System.out.println("TEXT : " + option.getText());

                try{

                    ((JavascriptExecutor) driver)
                            .executeScript("arguments[0].style.border='3px solid red'", option);

                    option.click();

                    break;

                }catch(Exception e){

                    System.out.println(e.getMessage());
                }
            }
        }

        public void EnterEmiratesID(String emiratesID){
        wait.until(ExpectedConditions.elementToBeClickable(IDNumberField)).sendKeys(String.valueOf(emiratesID));
        }

        public void IDExpiryDateSelection(){
            wait.until(ExpectedConditions.elementToBeClickable(PassportExpiryDateField)).click();

            LocalDate futureDate = LocalDate.now().plusDays(7);

            String day = String.valueOf(futureDate.getDayOfMonth());

            wait.until(ExpectedConditions.elementToBeClickable(selectExpiryDate(day))).click();

        }
        public void enterReason(String reason) {
            wait.until(ExpectedConditions.elementToBeClickable(selectReason)).sendKeys(reason);
        }
        public void clickGatePassSubmitButton(){
            wait.until(ExpectedConditions.elementToBeClickable(GatepassSubmittButton)).click();
        }
        public String getSuccessMessage() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(gatePassSuccessMessage)).getText();
        }
        public void clickGatePassSuccessOkButton() {
            wait.until(ExpectedConditions.elementToBeClickable(gatePassOkButton)).click();
        }
    }
