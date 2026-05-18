package modules.TransportServiceRequests.ServicerequestTest;

import base.SeleniumTest;
import modules.TransportServiceRequests.Servicerequestpage.TransportServiceRequestPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ServiceRequestOthers extends SeleniumTest {
    @Test(groups = "regression")
    @Parameters({"browser"})
    public void ServiceRequestTest(){
        driver.get(config.getProperty("app.url"));

        // Step 2: Login with credentials from config
        LoginPage Login = new LoginPage(driver);
        Login.enterUsername(config.getProperty("test.username", "shakeel.s22"));
        Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        Login.clickLogin();
        // Optional: wait for login to complete or dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Step 3: Open Leave Request page and submit a new request
        TransportServiceRequestPages transportPage = new TransportServiceRequestPages(driver);
        transportPage.openTransport();
        transportPage.openServiceRequest();
        transportPage.selectOthersCategory();
        transportPage.enterDescription("QA Automation");
        transportPage.uploadAttachment("C:\\Users\\sselvaraj01\\Pictures\\Screenshots\\Screenshot 2025-03-04 123127.png");
        transportPage.selectSubmit();
        //Validation
        String actualMsg = transportPage.getSuccessMessage();
        Assert.assertEquals(actualMsg, "Request submitted successfully.",
                "Success popup message is incorrect!");

        transportPage.clickSuccessOk();  // Optional if you need to close popup
    }
}
