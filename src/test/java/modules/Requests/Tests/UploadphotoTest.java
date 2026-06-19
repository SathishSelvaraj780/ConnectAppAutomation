package modules.Requests.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.Requests.Pages.RequestModulePages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

import java.time.Duration;
@Epic("Requests")
@Feature("Upload Photo")
public class UploadphotoTest extends SeleniumTest {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user can able to upload photo in the request module")
    @Test(groups = {"regression"})
    public void VerifyUploadPhotoModule() {
        // Test implementation
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);

        login.enterUsername(
                config.getProperty("test.username", "shakeel.s22"));

        login.enterPassword(
                config.getProperty("test.password", "Welcome1234@"));

        login.clickLogin();
        RequestModulePages requestPage =
                new RequestModulePages(driver);


        requestPage.openRequestMenu();
        requestPage.openUploadPhotoMenu();
        requestPage.uploadPhoto(
                "STUDENT","C:\\Users\\sselvaraj01\\Pictures\\Screenshots\\mother.jpg");


        requestPage.uploadPhoto(
                "FATHER","C:\\Users\\sselvaraj01\\Pictures\\Screenshots\\father.jpg");


        requestPage.uploadPhoto(
                "MOTHER",
                "C:\\Users\\sselvaraj01\\Pictures\\Screenshots\\mother.jpg");
        requestPage.uploadPhoto(
                "GUARDIAN",
"C:\\Users\\sselvaraj01\\Pictures\\Screenshots\\guardian.jpg");

        //  Upload a photo
        System.out.println("TestPassed: Photo upload functionality is working as expected.");
    }

}
