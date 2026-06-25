package modules.Transport.Tests;

import base.SeleniumTest;
import modules.Transport.Pages.TransportRegister;
import modules.login.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Debugclass extends SeleniumTest {

    @Test
    public void testDebug() {

        // Add your debugging logic here
        driver.get(config.getProperty("app.url"));
        LoginPage Login = new LoginPage(driver);
        Login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        Login.clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TransportRegister transportRegister = new TransportRegister(driver,wait);
        transportRegister.clickTransportMenu();
        transportRegister.clickTransportRequestAreaChangeButton();

    }
}
