package tests;

import base.SeleniumTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TransportPage;
import java.time.Duration;


public class TransportServiceRequest extends SeleniumTest {
    @Test(groups = "regression") @Parameters
    public void ServiceRequestTest(){
        driver.get(config.getProperty("app.url"));

        // Step 2: Login
        LoginPage Login = new LoginPage(driver);
        Login.enterUsername("shakeel.s22");
        Login.enterPassword("Welcome1234@");
        Login.clickLogin();
        // Optional: wait for login to complete or dashboard to load
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // Step 3: Open Leave Request page and submit a new request
        TransportPage transportPage = new TransportPage(driver);
        transportPage.openTransport();
        transportPage.openServiceRequest();
        transportPage.selectCategory();
        transportPage.enterDescription("I want leave");
        transportPage.uploadAttachment("C:\\Users\\sselvaraj01\\Pictures\\Screenshots\\Screenshot 2025-03-04 123127.png");
        transportPage.selectSubmit();
        //Validation
        String actualMsg = transportPage.getSuccessMessage();
        Assert.assertEquals(actualMsg, "Request submitted successfully.",
                "Success popup message is incorrect!");

        transportPage.clickSuccessOk();  // Optional if you need to close popup
    }

}

