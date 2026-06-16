package modules.TransportServiceRequests.ServicerequestTest;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.TransportServiceRequests.Servicerequestpage.TransportServiceRequestPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

@Epic("Transport Service Requests")
@Feature("Transport Service Request - RFID Category")

public class ServiceRequestRFID extends SeleniumTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate User able to Apply Transport Service Request with RFID Category")
    @Test
    public void VerifyUsercanapplyforRFID() {

    driver.get(config.getProperty("app.url"));
    LoginPage Login = new LoginPage(driver);
    Login.enterUsername(config.getProperty("test.username", "faizal.a9"));
    Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
    Login.clickLogin();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    TransportServiceRequestPages transportPage = new TransportServiceRequestPages(driver);
    transportPage.openTransport();
    transportPage.openServiceRequest();
    transportPage.selectRFIDCard();
    transportPage.selectIDType();
    transportPage.clickProceedtopay();
    // Handle alert if present
    try {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertMessage = alert.getText();

        System.out.println("ALERT MESSAGE: " + alertMessage);

        alert.accept();

        Assert.fail("Application displayed error alert: " + alertMessage);

    } catch (TimeoutException e) {

        wait.until(ExpectedConditions.urlContains(
                "ap-gateway.mastercard.com"));

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("ap-gateway.mastercard.com"));

    }
}

}
