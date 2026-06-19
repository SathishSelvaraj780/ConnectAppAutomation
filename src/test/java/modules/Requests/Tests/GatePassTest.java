package modules.Requests.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.Requests.Pages.RequestModulePages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("Requests")
@Feature("Apply Gatepass")
public class GatePassTest extends SeleniumTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user can able to apply gate pass request successfully")
    @Test(groups = {"regression"})
    public void VerifyGatePassRequestWorking() {
        // Test implementation
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();
        RequestModulePages requestPage = new RequestModulePages(driver);
        requestPage.openRequestMenu();
        requestPage.openGatepassmenu();
        requestPage.clickRequestGatepass();
        requestPage.clickSelectChildDropdown();
        requestPage.clickSelectChildDropdown();
        requestPage.selectChild("Samina Muath Shazeer");
        requestPage.selectDateandTime();
        requestPage.CHooseCurrentDateandTime("14", "16:00");
        requestPage.selectIDType("Emirates ID");
        requestPage.EnterEmiratesID("76545678");
        requestPage.IDExpiryDateSelection();
        requestPage.enterReason("Test Gate Pass Request");
        requestPage.clickGatePassSubmitButton();
        String actualMessage = requestPage.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains("Gate pass request saved successfully"));
        requestPage.clickGatePassSuccessOkButton();
        // Add steps to navigate to the Gate Pass section and click the success button
        System.out.println("TestPassed: Gate Pass success button is clickable and functioning as expected.");
    }
}
