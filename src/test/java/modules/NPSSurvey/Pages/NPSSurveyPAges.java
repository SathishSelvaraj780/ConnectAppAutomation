package modules.NPSSurvey.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NPSSurveyPAges {

    private By NPSSurveyTopMenu = By.xpath("//a[contains(@onclick,'showNpsSurvey()') and @id='sub-menu']");
    private By Surveyscale = By.xpath("//input[@class='form-range']");
    private By Enterreason = By.id("reasonTextarea");
    private By SubmitButton = By.xpath("//button[@class=\"button fill submitbutton\"]");
    private By CancelButton = By.id("NPSSurveyCancel");
    private By CancelPopupYes = By.id("yesButton");


    private final WebDriver driver;
    private final WebDriverWait wait;

    public NPSSurveyPAges(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickNPSSureveyTopMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(NPSSurveyTopMenu)).click();
    }
    public void clickSurveyscale() {
        WebElement slider = driver.findElement(By.xpath("//input[@class='form-range']"));

        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 50, 0).perform();
    }
    public void clickEnterreason(String reason) {
        driver.findElement(Enterreason).sendKeys(reason);

    }
    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();
    }
    public String  handlepopupMessage() {
        // Popup Message
        WebElement popupMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'messageFail')]")));

        String actualMessage = popupMessage.getText().trim();

        System.out.println("Popup Message: " + actualMessage);

        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Ok')]")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", okButton);

        System.out.println("Clicked OK button");

        return actualMessage;
    }
}
