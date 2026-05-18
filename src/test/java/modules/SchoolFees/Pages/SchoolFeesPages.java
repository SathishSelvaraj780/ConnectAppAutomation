package modules.SchoolFees.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SchoolFeesPages {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By FeePaymentTab = By.xpath("//*[@data-menutext='Fee & Payments']");
    private final By FeePayment = By.xpath("//a[contains(@data-menutext,'Fee Payment')]");
    private final By SchoolFeeTab = By.xpath("//a[contains(@href,'schoolFee')]");
    private final By TransportFeeTab = By.xpath("//a[contains(@href,'transportFee')]");
    private final By SchoolViewScheduleButton = By.xpath("//a[contains(@onclick,'ShowSchedule(')]");
    private final By SchedulePopup = By.xpath("//div[contains(@class,'card_design card_design-gems-co paymentCard selected')]");
    private final By SchoolfeeChooseCoBrandCard = By.xpath("//*[contains(@onclick, \"SetCardClass(this,'93SoG4LU7nk=')\")]");
    private final By SchoolfeeEnterAmountforSTU1 = By.xpath("//input[contains(@name,'PayAmount')]");
    private final By SchoolfeeEnterAmountforSTU2 = By.xpath("//input[contains(@name,'PayAmount')]");
    private final By SchoolfeeProceedtoPay = By.xpath("//button[@id='btnconfimration']");
    private final By FinalClickandProceedToPay = By.xpath("//a[@id='btnconfirm']");
    private final By Transporrtfeetab = By.xpath("//a[contains(@href,'transportFee')]");
    private final By Reedemslider = By.xpath("//input[@type='range' and @id='redeemSlider']");

    public SchoolFeesPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(40));
    }

    public void clickFeePaymentTab() {
        wait.until(ExpectedConditions.elementToBeClickable(FeePaymentTab)).click();
    }
    public void clickFeePayment() {
        wait.until(ExpectedConditions.elementToBeClickable(FeePayment)).click();
    }
    public void scrollToAmountField() {
        // Wait until data loads
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//input[contains(@name,'PayAmount')]"), 0
        ));

        WebElement element = driver.findElement(
                By.xpath("//input[contains(@name,'PayAmount')]")
        );

        // Scroll after load
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

    }
        public void enterAmountForStudent1(int amount) {
            WebElement amountField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            SchoolfeeEnterAmountforSTU1));

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].value='" + amount + "';" +
                            "arguments[0].dispatchEvent(new Event('input'));" +
                            "arguments[0].dispatchEvent(new Event('change'));",
                    amountField);
            amountField.sendKeys(Keys.TAB);

        }

        public void enterAmountForStudent2(int amount) {
        WebElement amountfield2= wait.until(ExpectedConditions.visibilityOfElementLocated(SchoolfeeEnterAmountforSTU2));
        amountfield2.clear();
        amountfield2.sendKeys(String.valueOf(amount));
        }
        public void clickProceedToPay() {
            Actions Action = new Actions(driver);
            Action.sendKeys(Keys.END).perform();
            wait.until(ExpectedConditions.elementToBeClickable(SchoolfeeProceedtoPay)).click();
        }
        public void waitForProceedButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(SchoolfeeProceedtoPay));
        }
        public void clickFinalProceedToPay() {
        wait.until(ExpectedConditions.elementToBeClickable(FinalClickandProceedToPay)).click();
        }

        public void clickViewSchedule() {
        wait.until(ExpectedConditions.elementToBeClickable(SchoolViewScheduleButton)).click();

        }
        public boolean isSchedulePopupDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SchedulePopup));
        return  driver.findElement(SchedulePopup).isDisplayed();
        }

    public void moveSliderToMaximum() {
        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(Reedemslider));
        int width = slider.getSize().getWidth();
        Actions move = new Actions(driver);
        move.clickAndHold(slider).moveByOffset(width, 0).release().perform();
    }
    public boolean isFinalProceedToPayDisplayed() {

        try {

            return wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    FinalClickandProceedToPay))
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
    public void clickWhenReady(By locator) {

        By overlay = By.cssSelector(".blockUI.blockOverlay");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }
    public void selectCoBrandCard() {
        wait.until(ExpectedConditions.elementToBeClickable(SchoolfeeChooseCoBrandCard)).click();
    }
}

