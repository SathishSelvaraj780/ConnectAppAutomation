package modules.StudentProfile.Tests;

import base.SeleniumTest;
import io.qameta.allure.*;
import modules.StudentProfile.Pages.StudentProfilePage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Epic("Student Profile")
@Feature("Basic Info Details")
public class BasicInfoTest extends SeleniumTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Student Profile Basic Info")
    @Test
    public void validateStudentProfile() throws InterruptedException {
        driver.get(config.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage login = new LoginPage(driver);
        login.enterUsername(config.getProperty("test.username", "faizal.a9"));
        login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
        login.clickLogin();

        StudentProfilePage studentProfilePage =new StudentProfilePage(driver);
        studentProfilePage.clickStudentProfileTopMenu();

        // Basic Info
        Assert.assertTrue(studentProfilePage.validateFieldAndValue("Student Name",
                "Athifa Faizal Ahmed"));
        Assert.assertTrue(studentProfilePage.validateFieldAndValue(
                "Student ID",
                "13100100040575"));
        // Contact Information
        Assert.assertTrue(
                studentProfilePage.validateFieldAndValue(
                        "Name",
                        "Muath Jon Shazeer"));
        // Joining Details
        studentProfilePage.openAccordion(
                "Joining Details");
        Assert.assertTrue(
                studentProfilePage.validateFieldAndValue(
                        "Joining Date",
                        "02/Apr/2017"));
        // Documents Details
        studentProfilePage.openAccordion(
                "Documents Details");
        Assert.assertTrue(
                studentProfilePage.validateFieldAndValue(
                        "Passport Number",
                        "20525577-PNOD"));
        // Language Details
        studentProfilePage.openAccordion(
                "Language Details");

        Assert.assertTrue(
                studentProfilePage.validateFieldAndValue(
                        "First Language",
                        "Arabic"));

        studentProfilePage.openAccordion("Sibling Info");
        Thread.sleep(2000);
        studentProfilePage.scrollToElement(By.xpath("//button[@id=\"btnSiblink\"]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"btnSiblink\"]")));
        studentProfilePage.scrollToTop();
        studentProfilePage.clickEditProfileButton();
        String actualUrl = driver.getCurrentUrl();
        String contains;
        Assert.assertEquals(actualUrl.contains("https://qa-connectv2.phoenixhse.com/Requests/StudentDetails"), true);

    }
}
