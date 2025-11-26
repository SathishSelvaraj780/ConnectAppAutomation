package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By username = By.id("UserName");
    private By password = By.id("Password");
    private By loginButton = By.id("submitLogin");
    private By errorMessage = By.xpath("//*[@class='text-danger text-center font14']");

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
