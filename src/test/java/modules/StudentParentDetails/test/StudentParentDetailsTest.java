package modules.StudentParentDetails.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.SeleniumTest;
import modules.StudentParentDetails.Page.StudentParentDetailsPage;
import modules.login.pages.LoginPage;

public class StudentParentDetailsTest extends SeleniumTest {

    @Test
    public void ParentDetailsUpdate() throws Exception {

        try {

            driver.get(config.getProperty("app.url"));

            LoginPage login = new LoginPage(driver);

            login.enterUsername(
                    config.getProperty("test.username", "Faizal.a9"));

            login.enterPassword(
                    config.getProperty("test.password", "Welcome1234@"));

            login.clickLogin();

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(ExpectedConditions.urlContains("Home/Home"));

            StudentParentDetailsPage parentDetails =
                    new StudentParentDetailsPage(driver);

            parentDetails.openRequestsMenu();

            parentDetails.openUpdateStudentDetailsMenu();

            Thread.sleep(5000);

            parentDetails.openParentDetailsMenu();

            System.out.println("Iframe count after opening Parent Details : "
                    + driver.findElements(By.tagName("iframe")).size());

          parentDetails.selectFeeSponsor();

          parentDetails.selectPreferredContact("Email");

        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
    }
}