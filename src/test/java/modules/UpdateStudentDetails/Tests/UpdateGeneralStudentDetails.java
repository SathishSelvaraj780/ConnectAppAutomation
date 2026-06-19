package modules.UpdateStudentDetails.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.UpdateStudentDetails.Pages.UpdatefieldsPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;


@Epic("Update Student Details KYC")
@Feature("General Details")

public class UpdateGeneralStudentDetails extends SeleniumTest {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate user able to Update General Student details")
    @Test(groups = "regression")
    public void TestUpdateStudentDetails() {
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();
        UpdatefieldsPages updatefieldsPages = new UpdatefieldsPages(driver);
        updatefieldsPages.clickStudentProfileTopMenu();
        updatefieldsPages.clickEditButton();
        updatefieldsPages.enterPassportNumber("DZYPSHMM09");
        updatefieldsPages.enterPassportIssuePlace("Kerala");
        updatefieldsPages.enterPassportIssueDate("20/May/2026");
        updatefieldsPages.enterPassportExpiryDate("20/May/2030");
        updatefieldsPages.enterVisaNumber("VZ123456");
        updatefieldsPages.enterVisaIssuePlace("Kerala");
        updatefieldsPages.enterVisaIssueDate("20/May/2026");
        updatefieldsPages.enterVisaExpiryDate("20/May/2030");
        updatefieldsPages.enterIssuingAuthority("Kerala Government");
        updatefieldsPages.enterNationalIDNumber("1234567890");
        updatefieldsPages.enterNationalIDExpiryDate("20/May/2030");
        updatefieldsPages.openLanguageDetailsAccordion();
        updatefieldsPages.selectMainLanguage("Spanish");
        updatefieldsPages.selectOtherLanguages(Arrays.asList("Hindi", "Arabic","Spanish"));
        Assert.assertEquals(updatefieldsPages.getSelectedMainLanguage(), "Spanish", "Main language selection failed");
        Assert.assertTrue(updatefieldsPages.getSelectedOtherLanguagesCount() == 3, "Other languages selection count mismatch");
        updatefieldsPages.openOtherInformationAccordion();
        updatefieldsPages.enterEmergencyContactName("John Doe");
        updatefieldsPages.enterEmergencyContactNo("9876543210");
        updatefieldsPages.setEmergencyContactrelationd("Relative");
        updatefieldsPages.enterStudentPersonalEmail("abcdefghi@example.com");

        updatefieldsPages.enterStudentPersonaMobileNumber("501234567");

        updatefieldsPages.clickUpdateButton();
        String actualPopupMessage = updatefieldsPages.handlepopupMessage();
        Assert.assertEquals(
                actualPopupMessage,"Updated successfully","Popup message mismatch after updating student details"
        );
    }
    }
