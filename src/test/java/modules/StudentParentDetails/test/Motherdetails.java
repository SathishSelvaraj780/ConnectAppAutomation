package modules.StudentParentDetails.test;

import base.SeleniumTest;
import modules.StudentParentDetails.Page.StudentParentDetailsPage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Motherdetails extends SeleniumTest {

    @Test
    public void Updatemotherdetails() throws InterruptedException {

        driver.get(config.getProperty("app.url"));

        LoginPage login = new LoginPage(driver);

        login.enterUsername(
                config.getProperty("test.username", "Faizal.a9"));

        login.enterPassword(
                config.getProperty("test.password", "Welcome1234@"));

        login.clickLogin();
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("Home/Home"));

        StudentParentDetailsPage parentDetails =
                new StudentParentDetailsPage(driver);

        parentDetails.openRequestsMenu();

        parentDetails.openUpdateStudentDetailsMenu();

        parentDetails.openParentDetailsMenu();

        //Method calling for Mother section
        WebElement motherSection =
                driver.findElement(By.id("secondAccordion"));

        System.out.println(
                motherSection.getAttribute("outerHTML"));

        parentDetails.expandMotherSection();
        parentDetails.scrollToMotherNationality();
        parentDetails.selectBootstrapDropdown(
                "motheR_NATIONALITY_ID",
                "British (United Kingdom)");
        System.out.println(
                "Mother Street count = " +
                        driver.findElements(By.id("motheR_STREET")).size());

        System.out.println(
                "Mother Nationality count = " +
                        driver.findElements(By.id("motheR_NATIONALITY_ID")).size());
        System.out.println(
                "Mother Street displayed = " +
                        driver.findElement(By.id("motheR_STREET"))
                                .isDisplayed());

        System.out.println(
                "Mother Nationality displayed = " +
                        driver.findElement(
                                        By.xpath("//button[@data-id='motheR_NATIONALITY_ID']"))
                                .isDisplayed());



// Mother Nationality
        WebElement motherNationalityButton =
                driver.findElement(
                        By.xpath("//button[@data-id='motheR_NATIONALITY_ID']"));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                motherNationalityButton);

        parentDetails.selectBootstrapDropdown(
                "motheR_NATIONALITY_ID2",
                "Canadian (Canada)");

        parentDetails.selectBootstrapDropdown(
                "motheR_COUNTRY_ID",
                "United Arab Emirates");

        parentDetails.selectBootstrapDropdown(
                "motherEmirate",
                "Dubai");

        parentDetails.selectBootstrapDropdown(
                "motheR_AREA_ID",
                "Dubai Marina");

// Address Details

        //parentDetails.enterMotherStreet("ABC Street");

        parentDetails.enterMotherBuildingName("Blue Building");

        parentDetails.enterMotherApartmentNumber("A-101");

        parentDetails.enterMotherPoBoxNumber("12345");

        parentDetails.enterMotherFax("110220");

// Contact Details

        parentDetails.enterMotherMobile("9638527400");

        parentDetails.enterMotherEmail("mother@gmail.com");

        parentDetails.enterMotherHomePhone("8754114964");

        parentDetails.enterMotherOfficePhone("523456789");

// Occupation

        parentDetails.enterMotherOccupation("Doctor");

        parentDetails.selectMotherCompany("Wipro");

        parentDetails.selectBootstrapDropdown(
                "guardiaN_NATIONALITY_ID",
                "British (United Kingdom)");

        parentDetails.selectBootstrapDropdown(
                "guardiaN_NATIONALITY_ID2",
                "Canadian (Canada)");

        parentDetails.selectBootstrapDropdown(
                "guardiaN_COUNTRY_ID",
                "United Arab Emirates");

        parentDetails.selectBootstrapDropdown(
                "guardianEmirate",
                "Dubai");

        parentDetails.selectBootstrapDropdown(
                "guardiaN_AREA_ID",
                "Dubai Marina");
    }
}
