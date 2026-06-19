package modules.TransportServiceRequests.ServicerequestTest;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.TransportServiceRequests.Servicerequestpage.TransportServiceRequestPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("Transport Service Requests")
@Feature("Transport Service Request - Single Day Category")
public class SingleDayServiceRequest extends SeleniumTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate User able to Apply Transport Service Request with Single Day Category")
    @Test(groups = "regression")
    public void VerifySingleDayServiceRequest(){
        driver.get(config.getProperty("app.url"));
        LoginPage Login = new LoginPage(driver);
        Login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        Login.clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TransportServiceRequestPages transportPage = new TransportServiceRequestPages(driver);
        transportPage.openTransport();
        transportPage.openServiceRequest();
        transportPage.selectSingleDayRequestButton();
        transportPage.clickSingleDayRequestButton();
        transportPage.selectDateSelection();
        transportPage.setSelectPickupordrop();
        transportPage.setEnterRemarks("QA Automation");
        transportPage.clickSaveButton();
        Assert.assertEquals(
                transportPage.selectRecordSavedText(),
                "Request saved successfully.",
                "Success popup message is incorrect!");
        transportPage.OktoRedirect();
    }
}
