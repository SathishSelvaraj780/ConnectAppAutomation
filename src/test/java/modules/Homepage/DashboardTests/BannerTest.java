package modules.Homepage.DashboardTests;
import base.SeleniumTest;
import io.qameta.allure.*;
import modules.Homepage.DashboardPages.BannerPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("Homepage")
@Feature("Banner Display")
public class BannerTest extends SeleniumTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate user can able to see the banner on the dashboard after login")
    @Test(groups = {"sanity", "regression"})
    public void verifyBannerIsDisplayed() {

        getDriver().get(config.getProperty("app.url"));
        LoginPage login = new LoginPage(getDriver());
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        WebDriverWait     wait =
                new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        // ✅ WAIT for dashboard element instead of URL
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='reward-carousel']")
        ));

        BannerPages bannerPage = new BannerPages(driver);

        boolean isDisplayed = bannerPage.isBannerDisplayed();

        Assert.assertTrue(isDisplayed, "❌ Banner is NOT displayed on Dashboard");
    }
}