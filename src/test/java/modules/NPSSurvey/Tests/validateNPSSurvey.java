package modules.NPSSurvey.Tests;

import base.SeleniumTest;
import modules.NPSSurvey.Pages.NPSSurveyPAges;
import modules.login.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validateNPSSurvey extends SeleniumTest {
    @Test
    public void verifyNPSSurveySubmission() {
        driver.get(config.getProperty("app.url"));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "mirah.a0"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();
        NPSSurveyPAges npsSurveyPAges = new NPSSurveyPAges(driver);
        npsSurveyPAges.clickNPSSureveyTopMenu();
        npsSurveyPAges.clickSurveyscale();
        npsSurveyPAges.clickEnterreason("QA Automation");
        npsSurveyPAges.clickSubmitButton();
        String popupText =
                npsSurveyPAges.handlepopupMessage();
        // Fail test if failure popup appears
        Assert.assertFalse(
                popupText.contains("Failed"),
                "Application returned failure popup: "
                        + popupText);

        // Pass test only for success popup
        Assert.assertTrue(
                popupText.contains("Success")
                        ||
                        popupText.contains("Successfully"),
                "Success popup not displayed");
    }
}
