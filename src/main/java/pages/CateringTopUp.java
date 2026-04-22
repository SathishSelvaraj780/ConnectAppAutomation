package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CateringTopUp {

    private WebDriver driver;
    private WebDriverWait wait;

    //Locators
    private By CateringTopMenu = By.xpath("//*[@data-menutext='Catering']");
    private By TopUpMenu = By.xpath("//*[@class='button fill btn-36']");
    private By PageFooter = By.xpath("//*[@class=\"page-footer ToArabicNumber\"]");
    private By InputAmountfield = By.xpath("//input[@data-val-number=\"The field PayAmount must be a number.\"]");
    private By ProceedtoPay = By.xpath("//button[@id='btnconfimration']");
    private By AlertPageProcced = By.xpath("//a[@id='btnconfirm']");
    private By AlertPageCancel = By.xpath("//button[@data-dismiss=\"modal\"]");

    public  CateringTopUp(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Open Catering Menu
    public void openCateringMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(CateringTopMenu)).click();
    }
    //Click TopUp
    public void openTopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(TopUpMenu)).click();
    }
    //Scroll down
    public void scrollDown(){
        Actions Action = new Actions(driver);
        Action.sendKeys(Keys.END).perform();
    }
    //Enter amount
    public void enterAmount(int amount){
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(InputAmountfield));
        amountField.clear();
        amountField.sendKeys(String.valueOf(amount));
    }
    //Proceed to payment
    public void clickProceed(){
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(ProceedtoPay));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", button);

        wait.until(ExpectedConditions.elementToBeClickable(button));

        try {
            button.click();
        } catch (Exception e) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", button);
        }
    }
    //Alert page proceed
    public void finalProceed(){
        wait.until(ExpectedConditions.elementToBeClickable(AlertPageProcced)).click();
    }

}

