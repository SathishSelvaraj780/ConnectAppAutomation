package modules.UpdateStudentDetails.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UpdatefieldsPages {

    WebDriver driver;
    WebDriverWait wait;

    private By StudentProfileTopMenu = org.openqa.selenium.By.xpath("//a[@href=\"/Child/Profile\"]");
    private By EditButton = org.openqa.selenium.By.xpath("//a[contains(@class,'filter') and contains(@href,'StudentDetails')]");
    private By PassportNumberfield = By.xpath("//input[@id=\"STU_PASPRTNO\"]");
    private By PassportIssuePlace = By.xpath("//input[@id=\"STU_PASPRTISSPLACE\"]");
    private By PassportIssueDate = By.xpath("//input[@id=\"STU_PASPRT_ISS_DATE\"]");
    private By PassportExpiryDate = By.xpath("//input[@id=\"STU_PASPRT_EXP_DATE\"]");
    private By VisaNumber = By.xpath("//input[@id=\"STU_VISA_NO\"]");
    private By VisaIssuePlace = By .xpath("//input[@id=\"STU_VISA_ISSUE_PACE\"]");
    private By VisaIssueDate = By.xpath("//input[@id=\"STU_VISA_ISSUE_DATE\"]");
    private By VisaExpiryDate = By.xpath("//input[@id=\"STU_VISA_EXPIRY_DATE\"]");
    private By IssuingAuthority = By.xpath("//input[@id=\"STU_VISA_ISSUING_AUTHORIT\"]");
    private By NationalIDNumber = By.xpath("//input[@id=\"STU_EMIRATES_ID\"]");
    private By NationalIDExpiry = By.xpath("//input[@id=\"stU_EMIRATES_ID_EXPDATE\"]");
    private By mainLanguageDropdown = By.id("stu_FIRSTLANG_ID");
    private By otherLanguagesDropdown = By.id("stU_OTHLANG_IDS");
    private By EmergencyContactName = By.xpath("//input[@id=\"STU_EMGCONTACT_NAME\"]");
    private By EmergencyContactrelationd = By.id("STU_EMGCONTACT_RELATION_ID");
    private By EmergencyContactNo = By.xpath("//input[@id=\"STU_EMG_CONTACT\"]");
    private By StudentEmail =By.xpath("//input[@id=\"STU_EMAIL\"]");
    private By StudentMobile=By.xpath("//input[@id=\"stU_MOBILE\"]");
    private By UpdateButton = By.xpath("//button[contains(@onclick,'saveStudentGeneralDetails()')]");
    private By ResetButton = By.xpath("//button[contains(@onclick,\"resetForm('general')\")]");
    private By LanuguageDetails = By.xpath("//span[@class='title' and normalize-space()='Language Details']");
    private By OtherInformation = By.xpath("//span[@class='title' and normalize-space()='Other Information']");
    private By mainLanguageDropdownButton = By.xpath("//button[@data-id='stU_FIRSTLANG_ID']");
    private By otherLanguagesDropdownButton = By.xpath("//button[@data-id='stU_OTHLANG_IDS']");
    private By emergencyRelationDropdownButton = By.xpath("//button[@data-id='STU_EMGCONTACT_RELATION_ID']");
    private By mobileValidationMessage  = By.xpath("//*[@id=\"stU_MOBILE-error\"]");
    private By emailValidationMessage = By.xpath("//*[@id=\"STU_EMAIL-error\"]");


    public UpdatefieldsPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
    }

    public void clickStudentProfileTopMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(StudentProfileTopMenu)).click();
    }
    public void waitForLoaderToDisappear() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'blockUI blockOverlay')]")));
    }
    @Step("Open Edit Profile to Update Student General Details")
    public void clickEditButton() {
        waitForLoaderToDisappear();

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        EditButton));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element);
    }

    @Step("Enter text '{1}' into field")
    public void enterText(By locator, String value) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        element.sendKeys(Keys.CONTROL + "a");

        element.sendKeys(Keys.DELETE);

        element.sendKeys(value);
    }

    
    @Step("Open Accordion : {0}")
    public void openLanguageDetailsAccordion() {

        WebElement accordion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        LanuguageDetails));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        accordion);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        accordion);
    }

    public void openOtherInformationAccordion() {
        WebElement accordion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        OtherInformation));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        accordion);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        accordion);

    }

    @Step("Select Language : {0}")
    public void selectMainLanguage(String language) {
        waitForLoaderToDisappear();

        WebElement dropdown = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        mainLanguageDropdownButton));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        dropdown);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        dropdown);

        WebElement option = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(String.format(
                                "//span[@class='text' and normalize-space()='%s']",
                                language))));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        option);
    }
    @Step("Select Other Language : {0}")
    public void selectOtherLanguages(List<String> languages) {

        WebElement dropdown = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        otherLanguagesDropdownButton));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        dropdown);

        for (String language : languages) {

            WebElement option = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath(String.format(
                                    "//span[@class='text' and normalize-space()='%s']",
                                    language))));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            option);
        }

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        dropdown);
    }
    public String getSelectedMainLanguage() {

        Select select = new Select(
                driver.findElement(
                        By.id("stU_FIRSTLANG_ID")));

        return select.getFirstSelectedOption().getText();
    }
    public int getSelectedOtherLanguagesCount() {

        Select select = new Select(
                driver.findElement(
                        By.id("stU_OTHLANG_IDS")));

        return select.getAllSelectedOptions().size();
    }

    public void selectDate(By locator, String date) {

        waitForLoaderToDisappear();

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].removeAttribute('readonly');",
                element);

        js.executeScript(
                "arguments[0].value = arguments[1];",
                element,
                date);

        js.executeScript(
                "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                element);

        js.executeScript(
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                element);

        js.executeScript(
                "arguments[0].blur();",
                element);

    }

    public void setEmergencyContactrelationd(String relation) {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        emergencyRelationDropdownButton));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        dropdown);

        dropdown.click();

        // WAIT SMALL TIME FOR OPTIONS
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // OPTION
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[normalize-space()='" + relation + "']")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        option);

    }

    @Step("Click Update Student Details")
     public void clickUpdateButton() {
        waitForLoaderToDisappear();

        WebElement updateBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        UpdateButton));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        updateBtn);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        updateBtn);

        // WAIT FOR SAVE PROCESS
        waitForLoaderToDisappear();
    }
    public String  handlepopupMessage() {
        // Wait until popup appears
        waitForLoaderToDisappear();

        // SUCCESS MESSAGE
        WebElement popupMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.messageSuccess")));

        String actualMessage = popupMessage.getText().trim();

        System.out.println("Popup Message : " + actualMessage);

        // OK BUTTON
        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.success-dialog-ok")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", okButton);

        return actualMessage;

    }

    public void enterPassportNumber(String value) {

        enterText(PassportNumberfield, value);
    }
    public void enterPassportIssuePlace(String value) {
        enterText(PassportIssuePlace, value);
    }
    public void enterPassportExpiryDate(String date) {
        selectDate(PassportExpiryDate, date);
    }
    public void enterPassportIssueDate(String date) {
        selectDate(PassportIssueDate, date);
    }
    public void enterVisaNumber(String value) {
        enterText(VisaNumber, value);
    }
    public void enterVisaIssuePlace(String value) {
        enterText(VisaIssuePlace, value);
    }
    public void enterVisaExpiryDate(String date) {
        selectDate(VisaExpiryDate, date);
    }
    public void enterVisaIssueDate(String date) {
        selectDate(VisaIssueDate, date);
    }
    public void enterIssuingAuthority(String value) {
        enterText(IssuingAuthority, value);
    }
    public void enterNationalIDNumber(String value) {
        enterText(NationalIDNumber, value);
    }
    public void enterNationalIDExpiryDate(String date) {
        selectDate(NationalIDExpiry, date);
    }
    public void enterEmergencyContactName(String value) {
        enterText(EmergencyContactName, value);
    }
    public void enterEmergencyContactNo(String value) {
        enterText(EmergencyContactNo, value);
    }
    public void enterStudentPersonalEmail(String value) {
        enterText(StudentEmail, value);
    }
    public void enterStudentPersonaMobileNumber(String value) {
        enterText(StudentMobile, value);

    }
    public boolean isEmailValidationDisplayed() {

        return !driver.findElements(emailValidationMessage).isEmpty();
    }

    public boolean isMobileValidationDisplayed() {

        return !driver.findElements(mobileValidationMessage).isEmpty();
    }
    public boolean isSuccessPopupDisplayed() {

        try {

            WebElement popup = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("div.messageSuccess")));

            return popup.isDisplayed();

        } catch (TimeoutException e) {

            return false;
        }
    }
}
