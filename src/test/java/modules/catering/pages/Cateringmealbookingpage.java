package modules.catering.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Cateringmealbookingpage {


    private WebDriver driver;
    private WebDriverWait wait;

    private By Catering = By.xpath("//*[@data-menutext='Catering']");
    private By OpenViewMenu = By.xpath("//button[normalize-space()='Order From Menu']");
    private By SearchField = By.xpath("//div[contains(@class,'tab-content active')]//input[@placeholder='Search']");
    private By CheckOutbutton = By.xpath("//button[@id=\"checkout-btn\"]");
    private By PickupPointdropdown = By.xpath("//select[@id=\"pickupPoint\"]");
    private By WalletBalance = By.id("walletBalance");
    private By EnableWalletBalance = By.id("chkEnable");
    private By SubmittButton = By.xpath("//button[contains(@onclick,'proceedToPayment()')]");
    private By loadingOverlay = By.cssSelector("div.blockUI.blockOverlay");


    public Cateringmealbookingpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Open Catering Menu")
    public void openCateringMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(Catering)).click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }


    public void openViewMenu(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.blockUI.blockOverlay")));

        WebElement viewMenu = driver.findElement(
                By.xpath("//button[contains(text(),'Order From Menu')]"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});",
                        viewMenu);

        wait.until(ExpectedConditions.elementToBeClickable(viewMenu));

        viewMenu.click();
    }

    @Step("Search and Add Item")
    public void orderItem(String itemName) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.blockUI.blockOverlay")));
        driver.findElement(SearchField).clear();
        driver.findElement(SearchField).sendKeys(itemName);

        By addBtn = By.xpath(
                "//button[@data-name='" + itemName + "']"
        );

        driver.findElement(addBtn).click();
    }

    public void checkoutItem() {
        wait.until(ExpectedConditions.elementToBeClickable(CheckOutbutton)).click();
    }
    @Step("Select Pickup Point")
    public void selectpickupPoint(String point) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.blockUI.blockOverlay")));

        WebElement dropdown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        PickupPointdropdown));

        Select select = new Select(dropdown);
        select.selectByVisibleText(point);

        System.out.println("Selected = "
                + select.getFirstSelectedOption().getText());
    }

    public String getWalletBalance() {
        return driver.findElement(WalletBalance).getText();
    }

    public void setEnableWalletBalance(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.blockUI.blockOverlay")));

        WebElement checkbox =
                driver.findElement(EnableWalletBalance);

        if (!checkbox.isSelected()) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", checkbox);
        }
    }

    @Step("Pay through Wallet Balance")
    public void clickSubmittButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SubmittButton)).click();
    }

    public  String getSuccessMessage() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.blockUI.blockOverlay")));

        List<WebElement> labels =
                driver.findElements(
                        By.xpath("//div[@class='modal-body']//label"));

        if (!labels.isEmpty()) {
            return labels.get(0).getText();
        }

        return "No success modal found";
    }
}
