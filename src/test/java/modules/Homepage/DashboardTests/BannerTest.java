package modules.Homepage.DashboardTests;
import base.SeleniumTest;
import modules.Homepage.DashboardPages.BannerPages;
import modules.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BannerTest extends SeleniumTest {

    @Test
    public void verifyBannerIsDisplayed() {

        driver.get(config.getProperty("app.url"));

        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "shakeel.s22"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // ✅ WAIT for dashboard element instead of URL
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='reward-carousel']")
        ));

        BannerPages bannerPage = new BannerPages(driver);

        boolean isDisplayed = bannerPage.isBannerDisplayed();

        Assert.assertTrue(isDisplayed, "❌ Banner is NOT displayed on Dashboard");
    }
}