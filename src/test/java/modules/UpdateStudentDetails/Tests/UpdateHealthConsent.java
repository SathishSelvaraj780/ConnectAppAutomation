package modules.UpdateStudentDetails.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.UpdateStudentDetails.Pages.UpdateHealthDetailPages;
import modules.UpdateStudentDetails.Pages.UpdatefieldsPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("Update Student Health Details")
@Feature("Health Details")
public class UpdateHealthConsent extends SeleniumTest {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user able to Update Student Health details")
    @Test
    public void verifyHealthDetailsUpdate() {
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();
        UpdatefieldsPages updatefieldsPages = new UpdatefieldsPages(driver);
        updatefieldsPages.clickStudentProfileTopMenu();
        updatefieldsPages.clickEditButton();
        UpdateHealthDetailPages healthPage = new UpdateHealthDetailPages (driver);
        healthPage.clickHealthTab();
        healthPage.enterHealthCardNumber("786677333");
        healthPage.selectBloodGroup("O+");
        healthPage.clickConfirmationCheckbox();
        healthPage.clickUpdateDetailsButton();
        String actualPopupMessage =
                healthPage.validateUpdatePopupAndClickOk();
        Assert.assertEquals(
                actualPopupMessage,
                "Update successfully",
                "Popup validation failed");
    }
}
