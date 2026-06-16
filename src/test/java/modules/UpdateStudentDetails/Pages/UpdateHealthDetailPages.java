package modules.UpdateStudentDetails.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class UpdateHealthDetailPages {

    WebDriver driver;
    WebDriverWait wait;

    private By StudentProfileTopMenu = org.openqa.selenium.By.xpath("//a[@href=\"/Child/Profile\"]");
    private By EditButton = org.openqa.selenium.By.xpath("//a[contains(@class,'filter') and contains(@href,'StudentDetails')]");
    private By HealthTab = By.xpath("//a[@href=\"#healthData\"]");
    private By HealthCardNumber = By.id("healthCardNo");
    private By SelectBloodGroup = By.xpath("//button[@data-id=\"bloodgroup\"]");
    private By ConfirmationCheckbox = By.id("chkConfirm");
    private By UpdateDetailsButton = By.xpath("//button[contains(@onclick,'updateHealthDetails()')]");
    private By ConsentCheckbox =         By.cssSelector("label[for='chkConfirm']");
    private By successMessage = By.xpath("//*[contains(text(),'Update successfully')]");
    private By loader = By.cssSelector(".blockUI.blockOverlay");
    private By OkButton = By.xpath("//button[normalize-space()='Ok']");



    public void waitForLoaderToDisappear() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    public UpdateHealthDetailPages(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @Step("Open Edit Profile to Update Student Health Details")
    public void clickHealthTab() {
        waitForLoaderToDisappear();
        WebElement tab= wait.until(ExpectedConditions.elementToBeClickable(HealthTab));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", tab);
    }

    public void enterHealthCardNumber(String cardNumber) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(HealthCardNumber));

        field.clear();
        field.sendKeys(cardNumber);
    }
    private By bloodGroupOption(String bloodGroup) {

        return By.xpath("//*[contains(text(),'" + bloodGroup + "')]");
    }

    public void selectBloodGroup(String bloodGroup) {

        // Open dropdown
        wait.until(ExpectedConditions.elementToBeClickable(SelectBloodGroup))
                .click();

        // Select option
        wait.until(ExpectedConditions.elementToBeClickable(
                        bloodGroupOption(bloodGroup)))
                .click();
    }

    public void clickConfirmationCheckbox() {

        WebElement checkbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ConsentCheckbox));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkbox);
    }

    public void clickUpdateDetailsButton() {


        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitForLoaderToDisappear();

        // Smooth scroll
        js.executeScript("window.scrollBy(0,1000)");

        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        UpdateDetailsButton));

        js.executeScript("arguments[0].scrollIntoView(true);", button);

        js.executeScript("arguments[0].click();", button);
    }

        @Step("Click Update Button and Validate update success popup is received")
        public String validateUpdatePopupAndClickOk() {
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
}
