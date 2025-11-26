package stepDefinitions;

import base.SeleniumTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import java.time.Duration;

public class Login1 extends SeleniumTest {

    LoginPage loginPage;

    @Given("user launches the connect app")
    public void user_launches_the_connect_app() {
        setUp("browser");  // from your SeleniumTest base class
        loginPage = new LoginPage(driver);
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() throws Exception {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("Password@123");
        loginPage.clickLogin();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(
                wait().until(ExpectedConditions.visibilityOfElementLocated(By.id("top-menu"))).isDisplayed(),
                "Dashboard not visible after login");
        tearDown();
    }
}

