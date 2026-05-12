package modules.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By username = By.id("UserName");
    private By password = By.id("Password");
    private By loginButton = By.id("submitLogin");
    private By errorMessage = By.xpath("//*[@class='text-danger text-center font14']");
    private By openProfile = By.xpath("//img[@alt='profile']");
    private By getselectLogout = By.xpath("//a[@href=\"/Account/Logout\"]");
    private By getselectprofilephoto = By.xpath("//a[@data-target=\"#upload_popup_profile\"]");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
    }

