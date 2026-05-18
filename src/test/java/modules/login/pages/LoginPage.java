package modules.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By username = By.id("UserName");
    private By password = By.id("Password");
    private By loginButton = By.id("submitLogin");
    private By errorMessage = By.xpath("//*[@class='text-danger text-center font14']");
    private By openProfile = By.xpath("//div[@class='user-action-dropdown']//img[@alt='profile']");
    private By getselectLogout = By.xpath("//a[@href=\"/Account/Logout\"]");
    private By getselectprofilephoto = By.xpath("//a[@data-target=\"#upload_popup_profile\"]");
    private By getuploadprofilephoto = By.cssSelector("input[type='file']");
    private By UpdateImage = By.xpath("//button[@onclick=\"updateProfileImage()\"]");
    private By ProfileUploadSuccessmessage = By.xpath("//div[contains(@class,'messageSuccess')]");
    private By ProfileUploadSuccessOkButton = By.xpath("//button[@class=\"button filter success-dialog-ok\"]");



    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // Actions
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickOnOpenProfile() {
        driver.findElement(openProfile).click();
    }

    public void clicklogout() {
        driver.findElement(getselectLogout).click();
    }

    public void clickprofilephoto() {
        driver.findElement(getselectprofilephoto).click();
    }

    public void FinalUpload(String filepath) {
        wait.until(ExpectedConditions
                        .presenceOfElementLocated(getuploadprofilephoto)).sendKeys(filepath);

        wait.until(ExpectedConditions
                        .presenceOfElementLocated(UpdateImage)).click();
    }

    public String getSuccessMessage() {

        wait.until(ExpectedConditions
                .presenceOfElementLocated(ProfileUploadSuccessmessage));

        String message = driver.findElement(ProfileUploadSuccessmessage).getText();

        wait.until(ExpectedConditions
                        .elementToBeClickable(ProfileUploadSuccessOkButton))
                .click();

        return message;
    }

}

