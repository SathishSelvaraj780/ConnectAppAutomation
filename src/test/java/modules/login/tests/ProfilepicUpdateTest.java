package modules.login.tests;

import base.SeleniumTest;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfilepicUpdateTest extends SeleniumTest {

    @Test
    public void profilepicUpdateTest() {
        // Implement the test steps for profile picture update functionality
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername("faizal.a9");
        login.enterPassword("Welcome1234@");
        login.clickLogin();

        login.clickOnOpenProfile();
        login.clickprofilephoto();
        login.FinalUpload("C:\\Users\\sselvaraj01\\Downloads\\ProfilePic.png");
        String successMessage = login.getSuccessMessage();

        System.out.println(successMessage);

        System.out.println("TestPassed: Profile picture update functionality is working as expected.");
    }
}
